import java.util.Comparator;
import java.util.PriorityQueue;

public class Student {

    public int age;
    public int groupNumber;
    public String name;
    public double rating;

    public Student(int age, int groupNumber, String name, double rating) {
        this.age = age;
        this.groupNumber = groupNumber;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name+"{" +
                "age=" + age +
                ", groupNumber=" + groupNumber +
                ", rating=" + rating +
                "}\n";
    }

    static Comparator<Student> compName = Comparator.comparing(o -> o.name);
    static Comparator<Student> compAge = Comparator.comparingInt(o -> o.age);
    static Comparator<Student> compGroupNumber = Comparator.comparingInt(o -> o.groupNumber);
    static Comparator<Student> compRaiting = Comparator.comparing(o -> o.rating);

    public static void sortName(Student ... students){
        PriorityQueue<Student> nameQ= new PriorityQueue(Student.compName);
        for (int i = 0; i < students.length; i++) {
            nameQ.offer(students[i]);
        }
        System.out.println("Сортировка по имени:");
        for (int i = 0; i < students.length; i++) {
            System.out.print(nameQ.poll());
        }
    }

    public static void sortAge(Student ... students){
        PriorityQueue<Student> ageQ= new PriorityQueue(Student.compAge);
        for (int i = 0; i < students.length; i++) {
            ageQ.offer(students[i]);
        }
        System.out.println("Сортировка по возрасту::");
        for (int i = 0; i < students.length; i++) {
            System.out.print(ageQ.poll());
        }
    }

    public static void sortGroupNumber(Student ... students){
        PriorityQueue<Student> groupNumberQ= new PriorityQueue(Student.compGroupNumber);
        for (int i = 0; i < students.length; i++) {
            groupNumberQ.offer(students[i]);
        }
        System.out.println("Сортировка по группе:");
        for (int i = 0; i < students.length; i++) {
            System.out.print(groupNumberQ.poll());
        }
    }

    public static void sortRaiting(Student ... students){
        PriorityQueue<Student> raitingQ= new PriorityQueue(Student.compRaiting);
        for (int i = 0; i < students.length; i++) {
            raitingQ.offer(students[i]);
        }
        System.out.println("Сортировка по рейтингу:");
        for (int i = 0; i < students.length; i++) {
            System.out.print(raitingQ.poll());
        }
    }

    public static void main(String[] args) {
        Student mansur = new Student(19,908,"Mansur",77);
        Student bulat = new Student(21,906,"Bulat",76);
        Student timur = new Student(20,907,"Timur",78);
        Student artem = new Student(25,902,"Artem",82);
        Student rasul = new Student(23,904,"Rasul",80);
        sortName(mansur,bulat,timur,artem,rasul);
        sortAge(mansur,bulat,timur,artem,rasul);
        sortGroupNumber(mansur,bulat,timur,artem,rasul);
        sortRaiting(mansur,bulat,timur,artem,rasul);
    }
}
