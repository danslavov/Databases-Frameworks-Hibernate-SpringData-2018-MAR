/*
Fof Judge, insert the Student class into this file
 */

package T04_Fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Set<Student> students = new LinkedHashSet<>();

//        p01_StudentsByGroup(students);
//        p02_StudentsByFirstAndLastName(students);
//        p03_StudentsByAge(students);
//        p04_SortStudents(students);
//        p05_FilterStudentsByEmailDomain(students);
//        p06_FilterStudentsByPhone(students);
//        p07_ExcellentStudents(students);
//        p08_WeakStudents(students);
//        p09_StudentsEnrolledIn2014Or2015(students);
//        p10_GroupByGroup(students);


    }

    private static void p10_GroupByGroup(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            s.setGroup(Integer.parseInt(params[2]));
            students.add(s);
        }

        students.stream()
                .collect(groupingBy(Student::getGroup, toList()))
                .forEach((key, value) -> System.out.printf("%d - %s%n",
                        key, value.toString()
                                .replace("[", "")
                                .replace("]", "")));
    }

    private static void p09_StudentsEnrolledIn2014Or2015(Set<Student> students) throws IOException {
        readStudentsByFacNumberAndGrades(students);
        students.stream()
                .filter(s -> s.getFacNumber().endsWith("14") || s.getFacNumber().endsWith("15"))
                .forEach(s -> System.out.println(s.getGrades()
                        .toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "")));
    }

    private static void p08_WeakStudents(Set<Student> students) throws IOException {
        readStudentsByNameAndGrades(students);
        students.stream()
                .filter(s -> isWeakStudent(s.getGrades()))
                .forEach(s -> System.out.printf("%s %s%n",
                        s.getFirstName(), s.getLastName()));
    }

    private static void p07_ExcellentStudents(Set<Student> students) throws IOException {
        readStudentsByNameAndGrades(students);
        students.stream()
                .filter(s -> s.getGrades().contains((byte) 6))
                .forEach(s -> System.out.printf("%s %s%n",
                        s.getFirstName(), s.getLastName()));
    }

    private static void p06_FilterStudentsByPhone(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            s.setPhone(params[2]);
            students.add(s);
        }
        students.stream()
                .filter(s -> s.getPhone().startsWith("02") || s.getPhone().startsWith("+3592"))
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }

    private static void p05_FilterStudentsByEmailDomain(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            s.setEmail(params[2]);
            students.add(s);
        }
        students.stream().filter(s -> s.getEmail().contains("@gmail"))
                .forEach(s -> System.out.printf(
                        "%s %s%n", s.getFirstName(), s.getLastName()));
    }

    private static void p04_SortStudents(Set<Student> students) throws IOException {
        readStudentsByName(students);
        students.stream()
                .sorted(Comparator.comparing(Student::getLastName).reversed()
                        .thenComparing(Student::getFirstName).reversed())
                .forEach(s -> System.out.printf(
                        "%s %s%n", s.getFirstName(), s.getLastName()));
    }

    private static void p03_StudentsByAge(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            s.setAge(Byte.parseByte(params[2]));
            students.add(s);
        }
        students.stream().filter(s -> (s.getAge() >= 18) && (s.getAge() <= 24))
                .forEach(s -> System.out.printf("%s %s %d%n",
                        s.getFirstName(), s.getLastName(), s.getAge()));

    }

    private static void p02_StudentsByFirstAndLastName(Set<Student> students) throws IOException {
        readStudentsByName(students);
        students.stream()
                .filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }

    private static void p01_StudentsByGroup(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            if (params[2].equals("2")) {
                students.add(s);
            }
        }
        students.stream().sorted(Comparator.comparing(Student::getFirstName))
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }


    // auxiliary methods:

    private static void readStudentsByName(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            students.add(s);
        }
    }

    private static void readStudentsByNameAndGrades(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFirstName(params[0]);
            s.setLastName(params[1]);
            for (int i = 2; i < params.length; i++) {
                s.getGrades().add(Byte.parseByte(params[i]));
            }
            students.add(s);
        }
    }

    private static void readStudentsByFacNumberAndGrades(Set<Student> students) throws IOException {
        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            String[] params = input.split("\\s+");
            Student s = new Student();
            s.setFacNumber(params[0]);
            for (int i = 1; i < params.length; i++) {
                s.getGrades().add(Byte.parseByte(params[i]));
            }
            students.add(s);
        }
    }

    private static boolean isWeakStudent(List<Byte> grades) {
        int count = 0;
        for (Byte g : grades) {
            if (g <= (byte) 3) {
                count++;
                if (count > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}