package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class P17_18_PhonebookPlusUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> phoneBook = new HashMap<>();
        String input;

        while (!"END".equals(input = reader.readLine())) {
            String[] params = input.split(" ");
            String command = params[0];


            switch (command) {
                case "A":
                    String name = params[1];
                    String phone = params[2];
                    phoneBook.put(name, phone);
                    break;
                case "S":
                    name = params[1];
                    if (phoneBook.containsKey(name)) {
                        System.out.println(name + " -> " + phoneBook.get(name));
                    } else {
                        System.out.printf("Contact %s does not exist.%n", name);
                    }
                    break;
                case "ListAll":
                    phoneBook.entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getKey))
                            .forEach(e -> System.out.println(
                                    e.getKey() + " -> " + e.getValue()));
            }
        }
    }
}
