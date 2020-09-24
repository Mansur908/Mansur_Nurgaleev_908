import java.awt.*;
import java.io.*;

public class Server {

    public static void file_404() throws IOException {
        File file = new File("404.html");
        if (!file.exists()){
            file.createNewFile();
        }
        PrintWriter pw = new PrintWriter(file);
        pw.println("404 Not Found");
        pw.close();
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(file.toURI());
    }

    public static void id () throws IOException {
        File file = new File("id.html");
        File file1 = new File("ID.txt");
        boolean exist = file.exists();
        if (!exist){
            file.createNewFile();
        }
        if (!exist) {
            PrintWriter pw = new PrintWriter(file);
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            pw.close();
        }
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(file.toURI());
    }

    public static void messages () throws IOException {
        File file = new File("messages.html");
        File file1 = new File("Messages.txt");
        boolean exist = file.exists();
        if (!exist){
            file.createNewFile();
        }
        if (!exist) {
            PrintWriter pw = new PrintWriter(file);
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            pw.close();
        }
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(file.toURI());
    }

    public static void feed () throws IOException {
        File file = new File("feed.html");
        File file1 = new File("Feed.txt");
        boolean exist = file.exists();
        if (!exist){
            file.createNewFile();
        }
        if (!exist) {
            PrintWriter pw = new PrintWriter(file);
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }
            pw.close();
        }
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(file.toURI());
    }

    public void readComand() throws IOException {
        System.out.println("Введите запрос:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        switch (s){
            case ("/id") : id();
            break;
            case ("/feed") : feed();
            break;
            case ("/messages") : messages();
            break;
            default : file_404();
            break;
        }
    }

    public static void main(String[] args) throws IOException {
        Server a = new Server();
        a.readComand();
    }
}
