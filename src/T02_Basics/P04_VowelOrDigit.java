package T02_Basics;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class P04_VowelOrDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        try {
            Integer.parseInt(input);
            System.out.println("digit");
        } catch (NumberFormatException nfe) {
            if ("aeiouy".contains(input)) {
                System.out.println("vowel");
            } else {
                System.out.println("other");
            }
        }
    }
}
