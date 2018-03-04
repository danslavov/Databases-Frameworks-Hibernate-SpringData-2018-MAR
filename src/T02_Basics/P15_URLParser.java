package T02_Basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15_URLParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String protocol = "";
        String server;
        String resources = "";
        String serverPlusResources;

        int firstIndex = input.indexOf("://");
        if (firstIndex >= 0) {
            protocol = input.substring(0,firstIndex);
            serverPlusResources = input.substring(firstIndex + 3);
        } else {
            serverPlusResources = input;
        }

        int secondIndex = serverPlusResources.indexOf("/");
        if (secondIndex >= 0) {
            server = serverPlusResources.substring(0, secondIndex);
            resources = serverPlusResources.substring(secondIndex + 1);
        } else {
            server = serverPlusResources;
        }

        System.out.printf("[protocol] = \"%s\"%n" +
                        "[server] = \"%s\"%n" +
                        "[resource] = \"%s\"%n",
                protocol, server, resources);
    }
}
