package T05_OOPPrinciples.p07_Mankind;

import T05_OOPPrinciples.p07_Mankind.models.Student;
import T05_OOPPrinciples.p07_Mankind.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] params = reader.readLine().split("\\s+");
        try {
            Student student = new Student(
                    params[0], params[1], params[2]);
            params = reader.readLine().split("\\s+");
            Worker worker = new Worker(
                    params[0], params[1],
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3]));

            printResult(student, worker);

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void printResult(Student student, Worker worker) {
        System.out.printf(
                "First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Faculty number: %s\n" +
                        "\n" +
                        "First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n",
                student.getFirstName(), student.getLastName(), student.getFacNumber(),
                worker.getFirstName(), worker.getLastName(),
                worker.getWeekSalary(), worker.getHoursPerDay(),
                worker.calculateSalaryPerHour()
        );
    }
}
