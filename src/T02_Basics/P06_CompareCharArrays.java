package T02_Basics;

import java.util.Scanner;

public class P06_CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] longer = scanner.nextLine().split(" ");
        String[] shorter = scanner.nextLine().split(" ");

        if (shorter.length > longer.length) {
            String[] temp = longer;
            longer = shorter;
            shorter = temp;
        }

        boolean firstPrintShorter = true;

        for (int i = 0; i < shorter.length; i++) {
            char shorterLetter = shorter[i].charAt(0);
            char longerLetter = longer[i].charAt(0);
            if (shorterLetter > longerLetter) {
                firstPrintShorter = false;
                break;
            } else if (longerLetter > shorterLetter) {
                break;
            }
        }

        if (firstPrintShorter) {
            printResult(shorter, longer);
        } else {
            printResult(longer, shorter);
        }
    }

    private static void printResult(String[] first, String[] second) {
        System.out.println(String.join("", first));
        System.out.println(String.join("", second));
    }
}
