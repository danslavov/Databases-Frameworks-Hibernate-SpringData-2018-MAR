package T03_OOPOverview.P09_Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            Student student = new Student(input);
        }
        System.out.println(Student.getCount());
    }
}
