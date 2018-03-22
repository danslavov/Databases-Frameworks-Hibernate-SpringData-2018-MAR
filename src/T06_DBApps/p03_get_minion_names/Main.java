package T06_DBApps.p03_get_minion_names;

import T06_DBApps.MyDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try(Connection conn = MyDriver.getConnection("minionsDB");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            PreparedStatement ps = conn.prepareStatement(
                    "SELECT v.villain_name, m.minion_name, m.minion_age\n" +
                            "FROM minions AS m\n" +
                            "JOIN minions_villains AS mv ON m.minion_id = mv.minion_id\n" +
                            "RIGHT JOIN villains AS v ON mv.villain_id = v.villain_id\n" +
                            "WHERE v.villain_id = ?;");
            int villainId = Integer.parseInt(reader.readLine());
            ps.setInt(1, villainId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Villain: " + rs.getString("villain_name"));
                int counter = 1;
                rs.beforeFirst();
                while (rs.next()) {
                    String minionName = rs.getString("minion_name");
                    if (minionName == null) {
                        System.out.println("<no minions>");
                        break;
                    }
                    System.out.printf("%d. %s %d\n",
                            counter,
                            rs.getString("minion_name"),
                            rs.getInt(("minion_age")));
                    counter++;
                }
            } else {
                System.out.printf("No villain with ID %d exists in the database.", villainId);
            }

        } catch (SQLException | IOException e) {
            System.out.println("Unknown error. Please try again :)");
        }
    }
}
