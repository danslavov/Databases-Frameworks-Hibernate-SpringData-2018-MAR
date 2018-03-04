package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16_ChangeToUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int start;
        while ((start = input.indexOf("<upcase>")) >= 0) {
            int end = input.indexOf("</upcase>");
            String found = input.substring(start + 8, end);
            String upper = found.toUpperCase();
            input = input.replace("<upcase>" + found + "</upcase>", upper);
        }
        System.out.println(input);
    }
}
