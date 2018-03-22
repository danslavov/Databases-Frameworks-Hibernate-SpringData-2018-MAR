package T06_DBApps.p07_print_all_minion_names;

import T06_DBApps.MyDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = MyDriver.getConnection("minionsDB")) {

            Statement getMinions = conn.createStatement();
            ResultSet rs = getMinions.executeQuery(
                    "SELECT m.minion_name FROM minions AS m " +
                            "ORDER BY minion_id;");
            List<String> minions = new ArrayList<>();
            while (rs.next()) {
                minions.add(rs.getString("minion_name"));
            }

            printResultImproved(minions);
//            printResult(minions);

        } catch (SQLException se) {
            System.out.println("Unknown error. Please try again :)");
        }
    }

    private static void printResultImproved(List<String> minions) {
        List<String> funnyOrdered = new LinkedList<>();
        for (int i = 0; i < minions.size(); i++) {
            String currentMinion = minions.get(i);
            if (i % 2 == 0) {
                    funnyOrdered.add(funnyOrdered.size()/2, currentMinion);
            } else {
                    funnyOrdered.add(funnyOrdered.size()/2 + 1, currentMinion);
            }
        }
        funnyOrdered.forEach(System.out::println);
    }

    private static void printResult(List<String> minions) {
        List<String> even = new ArrayList<>();
        List<String> odd = new ArrayList<>();

        for (int i = 0; i < minions.size(); i++) {
            if (i % 2 == 0) {
                even.add(minions.get(i));
            } else {
                odd.add(minions.get(i));
            }
        }
        Collections.reverse(odd);
        even.forEach(System.out::println);
        odd.forEach(System.out::println);
    }
}
