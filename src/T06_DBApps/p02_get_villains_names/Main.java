package T06_DBApps.p02_get_villains_names;

import T06_DBApps.MyDriver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = MyDriver.getConnection("minionsDB")) {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT v.villain_name AS v_name, count(*) AS m_count\n" +
                            "FROM villains AS v\n" +
                            "JOIN minions_villains AS mv ON v.villain_id = mv.villain_id\n" +
                            "GROUP BY v_name\n" +
                            "HAVING m_count > 3;");
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    System.out.printf("%s %d\n",
                            rs.getString("v_name"),
                            rs.getInt("m_count"));
                }
            }
        } catch (SQLException se) {
            System.out.println("Unknown error. Please try again :)");
        }
    }
}
