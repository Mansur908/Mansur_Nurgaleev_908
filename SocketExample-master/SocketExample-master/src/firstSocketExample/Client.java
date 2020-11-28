package firstSocketExample;

public class Client {

    public static String Addr = "localhost";
    public static int port = 8081;

    public static void main(String[] args) {
        new ClientSomthing(Addr, port);
    }
}