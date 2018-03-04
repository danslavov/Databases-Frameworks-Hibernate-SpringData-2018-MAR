package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14_CensorEmailAddress {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String email = reader.readLine();
        String text = reader.readLine();
        Pattern pattern = Pattern.compile("(?<username>.+(?=@))");
        Matcher matcher = pattern.matcher(email);
        String censoredText = "";
        if (matcher.find()) {
            String match = matcher.group("username");
            String stars = match.replaceAll(".", "*");
            String censoredEmail = stars + email.substring(email.indexOf("@"));
            censoredText = text.replace(email, censoredEmail);
        }
        System.out.println(censoredText);
    }
}
