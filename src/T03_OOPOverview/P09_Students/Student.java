package T03_OOPOverview.P09_Students;

public class Student {

    private static int count = 0;

    private String name;

    public Student(String name) {
        this.name = name;
        Student.count++;
    }

    public static int getCount() {
        return Student.count;
    }
}
