package T02_Basics;

import java.util.Scanner;

public class P03_ReverseCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char third = scanner.nextLine().charAt(0);
//        System.out.println("" + third + second + first);
        System.out.println(
                new StringBuilder()
                        .append(third)
                        .append(second)
                        .append(first));
    }
}
