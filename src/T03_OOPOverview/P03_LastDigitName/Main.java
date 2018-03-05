package T03_OOPOverview.P03_LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int digit = input.charAt(input.length() - 1) - '0';
        Number myNumber = new Number(digit);
        System.out.println(myNumber.getLastDigitName());
    }
}
