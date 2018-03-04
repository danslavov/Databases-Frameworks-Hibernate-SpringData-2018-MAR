package T02_Basics;

import java.util.Scanner;

public class P02_BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                Boolean.parseBoolean(scanner.nextLine()) ? "Yes" : "No");
    }
}
