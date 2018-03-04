// 90/100 in Judge

package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P15_URLParser_regex {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Pattern pattern = Pattern.compile(
                "(?<protocol>\\w+(?=:))*[:/]*" +
                        "(?<server>\\w+\\.\\w+[\\w.]*)/*" +
                        "(?<resources>.*)"
        );

        String protocol = "";
        String server = "";
        String resources = "";

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.group("protocol") != null) {
                protocol = matcher.group("protocol");
            }
            if (matcher.group("server") != null) {
                server = matcher.group("server");
            }
            if (matcher.group("resources") != null) {
                resources = matcher.group("resources");
            }
        }

        System.out.printf("[protocol] = \"%s\"%n" +
                        "[server] = \"%s\"%n" +
                        "[resource] = \"%s\"%n",
                protocol, server, resources);
    }
}
