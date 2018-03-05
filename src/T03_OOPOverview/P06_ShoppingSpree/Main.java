package T03_OOPOverview.P06_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Person> people = new LinkedHashMap();
        Map<String, Product> products = new LinkedHashMap<>();
        String[] inputPeople = reader.readLine().split(";");
        String[] inputProducts = reader.readLine().split(";");

        try {

            for (String p : inputPeople) {
                String[] params = p.split("=");
                String name = params[0];
                double money = Double.parseDouble(params[1]);
                people.put(name, new Person(name, money));
            }

            for (String p : inputProducts) {
                String[] params = p.split("=");
                String name = params[0];
                double price = Double.parseDouble(params[1]);
                products.put(name, new Product(name, price));
            }

            String command;
            while (!"END".equalsIgnoreCase(command = reader.readLine())) {
                if (command == null) {
                    continue;
                }
                String[] params = command.split(" ");
                String personName = params[0];
                String productName = params[1];
                Person person = people.get(personName);
                Product product = products.get(productName);
                if (person != null && product != null) {
                    try {
                        person.buy(product);
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                }
            }

            for (Person p : people.values()) {
                p.printResult();
                System.out.println();
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
