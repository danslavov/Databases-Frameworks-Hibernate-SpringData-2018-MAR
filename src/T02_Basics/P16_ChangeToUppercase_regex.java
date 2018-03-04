// 83/100 in Judge

package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P16_ChangeToUppercase_regex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(?<=<upcase>)[\\w\\s]*(?=</upcase>)");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String found = matcher.group();
            String upper = found.toUpperCase();
            input = input.replaceAll("<upcase>" + found + "</upcase>", upper);
        }
        System.out.println(input);
    }
}
