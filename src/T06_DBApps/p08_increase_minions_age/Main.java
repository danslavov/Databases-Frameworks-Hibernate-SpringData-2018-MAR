package T06_DBApps.p08_increase_minions_age;

import T06_DBApps.MyDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = MyDriver.getConnection("minionsDB");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            conn.setAutoCommit(false);
            int[] ids = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            String increaseAge = "UPDATE minions AS m SET m.minion_age = m.minion_age + 1 " +
                    "WHERE m.minion_id IN (?);";
            String titleCase = "UPDATE minions AS m SET m.minion_name = " +
                    "concat(upper(left(m.minion_name, 1)), substr(m.minion_name, 2)) " +
                    "WHERE m.minion_id IN (?);";
            try {
                createAndExecuteStatement(conn, ids, increaseAge);
                createAndExecuteStatement(conn, ids, titleCase);
                printResult(conn);
                conn.commit();

            } catch (SQLException se) {
                conn.rollback();
                conn.setAutoCommit(true);
                throw new SQLException();
            }

        } catch (SQLException | IOException e) {
            System.out.println("Unknown error. Please try again :)");
        }
    }

    private static void printResult(Connection conn) throws SQLException {
        Statement printAllMinions = conn.createStatement();
        ResultSet rs = printAllMinions.executeQuery(
                "SELECT m.minion_name, m.minion_age FROM minions AS m;");
        while (rs.next()) {
            System.out.printf("%s %d\n",
                    rs.getString("minion_name"),
                    rs.getInt("minion_age"));
        }
    }

    private static void createAndExecuteStatement(Connection conn, int[] ids, String stm) throws SQLException {
        // create the same number of placeholders as are the input ids
        StringBuilder sb = new StringBuilder();
        for (int id : ids) {
            sb.append("?,");
        }

        // put them into a query
        stm = stm.replace("?", sb.deleteCharAt(sb.length() - 1));
        PreparedStatement ps = conn.prepareStatement(stm);

        // assign the id values to all placeholders
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            int position = i + 1;
            ps.setInt(position, id);
        }
        ps.executeUpdate();
    }
}
