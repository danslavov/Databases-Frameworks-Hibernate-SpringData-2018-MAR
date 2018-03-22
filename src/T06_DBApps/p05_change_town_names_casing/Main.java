package T06_DBApps.p05_change_town_names_casing;

import T06_DBApps.MyDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = MyDriver.getConnection("minionsDB");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String country = reader.readLine();

            PreparedStatement toUppercase = conn.prepareStatement(
                    "UPDATE towns SET town_name = UPPER(town_name)" +
                            "WHERE country = ?;");
            toUppercase.setString(1, country);
            int affectedRows = toUppercase.executeUpdate();

            if (affectedRows > 0) {

                PreparedStatement getTowns = conn.prepareStatement(
                        "SELECT t.town_name FROM towns AS t " +
                                "WHERE t.country = ?;");
                getTowns.setString(1, country);
                ResultSet rs = getTowns.executeQuery();
                List<String> towns = new ArrayList<>();
                while (rs.next()) {
                    towns.add(rs.getString("town_name"));
                }
                System.out.printf("%d town names were affected.\n", affectedRows);
                System.out.println(towns);

            } else {
                System.out.println("No town names were affected.");
            }

        } catch (SQLException | IOException e) {
            System.out.println("Unknown error. Please try again :)");
        }
    }
}
