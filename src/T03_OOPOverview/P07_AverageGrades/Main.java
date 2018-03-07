package T03_OOPOverview.P07_AverageGrades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Student> students = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s");
            String name = params[0];
            List<Double> grades = new ArrayList<>();

            for (int j = 1; j < params.length; j++) {
                double grade = Double.parseDouble(params[j]);
                grades.add(grade);
            }

            Student student = new Student(name, grades);
            students.add(student);
        }

        students.stream()
                .filter(s -> s.getAverageGrade() >= 5.0)
                .sorted(Comparator.comparing(Student::getName)
                                .thenComparing((s1, s2) -> Double.compare(
                                        s2.getAverageGrade(), s1.getAverageGrade())))
                .forEach(s -> System.out.printf("%s -> %.2f%n",
                        s.getName(), s.getAverageGrade()));
    }
}
