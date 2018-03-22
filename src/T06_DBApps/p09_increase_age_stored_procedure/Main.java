package T06_DBApps.p09_increase_age_stored_procedure;

import T06_DBApps.MyDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = MyDriver.getConnection("minionsDB");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int id = Integer.parseInt(reader.readLine());

//            createProcedure(conn);

            CallableStatement callGetOlderProcedure = conn.prepareCall("{call usp_get_older(?)}");
            callGetOlderProcedure.setInt(1, id);
            callGetOlderProcedure.executeUpdate();

            printResult(conn, id);

        } catch (SQLException | IOException e) {
            System.out.println("Ooops, something went wrong!");
        }
    }

    private static void printResult(Connection conn, int id) throws SQLException {
        PreparedStatement printMinion = conn.prepareStatement(
                "SELECT m.minion_name, m.minion_age FROM minions AS m " +
                        "WHERE m.minion_id = ?;");
        printMinion.setInt(1, id);
        ResultSet rs = printMinion.executeQuery();
        if (rs.next()) {
            System.out.printf("%s %d\n",
                    rs.getString("minion_name"),
                    rs.getInt("minion_age"));
        }
    }

    private static void createProcedure(Connection conn) throws SQLException {
        PreparedStatement dropProcedure = conn.prepareStatement(
                "DROP PROCEDURE IF EXISTS usp_get_older;");
        dropProcedure.executeUpdate();
        PreparedStatement createGetOlderProcedure = conn.prepareStatement(
                "CREATE PROCEDURE usp_get_older(input_id INT) " +
                        "BEGIN " +
                        "UPDATE minions AS m SET m.minion_age = m.minion_age + 1 " +
                        "WHERE m.minion_id = input_id; " +
                        "END;");
        createGetOlderProcedure.executeUpdate();
    }
}
