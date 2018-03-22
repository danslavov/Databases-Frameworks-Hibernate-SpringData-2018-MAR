package T06_DBApps.p06_remove_villain;

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
        try (Connection conn = MyDriver.getConnection("minionsDB");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            try {
                int villainId = Integer.parseInt(reader.readLine());
                conn.setAutoCommit(false);

                PreparedStatement setForeignKeyChecks = conn.prepareStatement(
                        "SET FOREIGN_KEY_CHECKS=?;");
                setForeignKeyChecks.setInt(1, 0);
                setForeignKeyChecks.executeUpdate();

                PreparedStatement getVillainName = conn.prepareStatement(
                        "SELECT v.villain_name FROM villains AS v " +
                                "WHERE v.villain_id = ?");
                getVillainName.setInt(1, villainId);
                ResultSet rs = getVillainName.executeQuery();
                String villainName;

                if (rs.next()) {

                    villainName = rs.getString("villain_name");

                    PreparedStatement releaseMinions = conn.prepareStatement(
                            "DELETE FROM minions_villains WHERE villain_id = ?;");
                    releaseMinions.setInt(1, villainId);
                    int affectedRows = releaseMinions.executeUpdate();

                    PreparedStatement deleteVillain = conn.prepareStatement(
                            "DELETE FROM villains WHERE villain_id = ?;");
                    deleteVillain.setInt(1, villainId);
                    deleteVillain.executeUpdate();

                    System.out.println(villainName + " was deleted");
                    System.out.println(affectedRows + " minions released");

                } else {
                    System.out.println("No such villain was found");
                }

                setForeignKeyChecks.setInt(1, 1);
                setForeignKeyChecks.executeUpdate();
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
}
