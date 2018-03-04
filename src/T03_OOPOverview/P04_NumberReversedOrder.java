package T03_OOPOverview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04_NumberReversedOrder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        DecimalNumber dn = new DecimalNumber(input);
        dn.printReversed();
    }
}
