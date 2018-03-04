package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13_FitStringIn20Chars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        char[] symbols = new char[20];
        for (int i = 0; i < symbols.length; i++) {
            char symbol;
            if (i > input.length() - 1) {
                symbol = '*';
            } else {
                symbol = input.charAt(i);
            }
            symbols[i] = symbol;
        }
        for (char symbol : symbols) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
