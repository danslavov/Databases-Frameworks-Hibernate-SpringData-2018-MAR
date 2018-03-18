package T05_OOPPrinciples;

import T05_OOPPrinciples.interfaces.Birthable;
import T05_OOPPrinciples.interfaces.Car;
import T05_OOPPrinciples.interfaces.Identifiable;
import T05_OOPPrinciples.models.*;
import T05_OOPPrinciples.interfaces.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        p01_DefineInterfacePerson();
//        p02_MultipleImplementation();
//        p03_Ferrari();
//        p04_Telephony();
//        p05_BorderControl();
//        p06_BirthdayCelebrations();
    }

//    private static void p06_BirthdayCelebrations() throws IOException {
//        List<Birthable> list = new ArrayList<>();
//        String input;
//        while (!"end".equalsIgnoreCase(input = reader.readLine().trim())) {
//            String[] params = input.split("\\s+");
//            if ("citizen".equalsIgnoreCase(params[0])) {
//                list.add(new Citizen(params[1],
//                        Integer.parseInt(params[2]),
//                        params[3],
//                        params[4]));
//            } else if ("pet".equalsIgnoreCase(params[0])) {
//                list.add(new Pet(params[1], params[2]));
//            }
//        }
//        String year = reader.readLine();
//        list.stream()
//                .filter(b -> b.getBirthDate().endsWith(year))
//                .forEach(b -> System.out.println(b.getBirthDate()));
//    }

//    private static void p05_BorderControl() throws IOException {
//        List<Identifiable> list = new ArrayList<>();
//        String input;
//        while (!"end".equalsIgnoreCase(input = reader.readLine().trim())) {
//            String[] params = input.split("\\s+");
//            if (params.length == 3) {
//                list.add(new NewCitizen(params[0],
//                        Integer.parseInt(params[1]),
//                        params[2]));
//            } else {
//                list.add(new Robot(params[0], params[1]));
//            }
//        }
//        String ending = reader.readLine().trim();
//        list.stream()
//                .filter(i -> i.getId().endsWith(ending))
//                .forEach(i -> System.out.println(i.getId()));
//    }
//
//    private static void p04_Telephony() throws IOException {
//        List<String> phones = Arrays.stream(reader.readLine().split("\\s+"))
//                .collect(Collectors.toList());
//        List<String> sites = Arrays.stream(reader.readLine().split("\\s+"))
//                .collect(Collectors.toList());
//        Smartphone smartphone = new Smartphone(phones, sites);
//        smartphone.call();
//        smartphone.browse();
//
//    }
//
//    private static void p03_Ferrari() throws IOException {
//        String driver = reader.readLine();
//        Car myCar = new Ferrari(driver);
//        System.out.print(myCar.getModel());
//        System.out.print("/");
//        myCar.brake();
//        System.out.print("/");
//        myCar.drive();
//        System.out.print("/");
//        System.out.println(myCar.getDriver());
//
//        String ferrariName = Ferrari.class.getSimpleName();
//        String carInterface = Car.class.getSimpleName();
//        boolean isCreated = Car.class.isInterface();
//        if (!isCreated) {
//            try {
//                throw new IllegalClassFormatException("No interface created!");
//            } catch (IllegalClassFormatException icfe) {
//                System.out.println(icfe.getMessage());
//            }
//        }
//    }
//
//    private static void p02_MultipleImplementation() {
//        Class[] citizenInterfaces = Citizen.class.getInterfaces();
//        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
//                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
//            Method[] methods = Birthable.class.getDeclaredMethods();
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            methods = Identifiable.class.getDeclaredMethods();
//            System.out.println(methods.length);
//            System.out.println(methods[0].getReturnType().getSimpleName());
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.nextLine();
//            int age = Integer.parseInt(scanner.nextLine());
//            String id = scanner.nextLine();
//            String birthdate = scanner.nextLine();
//            Identifiable identifiable = new Citizen(name, age, id, birthdate);
//            Birthable birthable = new Citizen(name, age, id, birthdate);
//        }
//    }
//
//    private static void p01_DefineInterfacePerson() {
//        Class[] citizenInterfaces = Citizen.class.getInterfaces();
//        if (Arrays.asList(citizenInterfaces).contains(Person.class)) {
//            Method[] fields = Person.class.getDeclaredMethods();
//            System.out.println(fields.length);
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.nextLine();
//            int age = Integer.parseInt(scanner.nextLine());
//            Person person = new Citizen(name, age, null, null);
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//        }
//    }
}
