package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12_ReverseString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        for (int i = input.length() - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
        System.out.println();
    }
}
