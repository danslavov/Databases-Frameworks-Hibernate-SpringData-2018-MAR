package T02_Basics;

import java.util.Scanner;

public class P01_VariableInHexadecimalFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                Integer.parseInt(scanner.nextLine(), 16)
        );
    }
}
