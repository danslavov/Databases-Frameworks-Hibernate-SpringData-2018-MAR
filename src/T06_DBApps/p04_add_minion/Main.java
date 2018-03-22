package T06_DBApps.p04_add_minion;

import T06_DBApps.MyDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = MyDriver.getConnection("minionsDB");
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            try {
                String[] minionParams = reader.readLine()
                        .substring(8).split("\\s+");
                String minionName = minionParams[0];
                int minionAge = Integer.parseInt(minionParams[1]);
                String town = minionParams[2];
                String villainName = reader.readLine().substring(9);

                conn.setAutoCommit(false);

                addUniqueIndex(conn);

                PreparedStatement insertTown = conn.prepareCall(
                        "INSERT IGNORE INTO towns(town_name) VALUES (?);");
                insertTown.setString(1, town);
                int affectedRows = insertTown.executeUpdate();
                if (affectedRows != 0) {
                    System.out.printf("Town %s was added to the database.\n", town);
                }

                PreparedStatement insertVillain = conn.prepareCall(
                        "INSERT IGNORE INTO villains(villain_name, evilness) " +
                                "VALUES (?, 'evil');");
                insertVillain.setString(1, villainName);
                affectedRows = insertVillain.executeUpdate();
                if (affectedRows != 0) {
                    System.out.printf("Villain %s was added to the database.\n", villainName);
                }

                PreparedStatement insertMinion = conn.prepareCall(
                        "INSERT IGNORE INTO minions(minion_name, minion_age, town_id)" +
                                "VALUES (?, ?," +
                                "(SELECT t.town_id FROM towns AS t WHERE t.town_name = ?));");
                insertMinion.setString(1, minionName);
                insertMinion.setInt(2, minionAge);
                insertMinion.setString(3, town);
                insertMinion.executeUpdate();

                PreparedStatement linkMinionToVillain = conn.prepareCall(
                        "INSERT IGNORE INTO minions_villains VALUES (" +
                                "(SELECT m.minion_id FROM minions AS m WHERE m.minion_name = ?)," +
                                "(SELECT v.villain_id FROM villains AS v WHERE v.villain_name = ?));");
                linkMinionToVillain.setString(1, minionName);
                linkMinionToVillain.setString(2, villainName);
                affectedRows = linkMinionToVillain.executeUpdate();
                if (affectedRows != 0) {
                    System.out.printf("Successfully added %s to be minion of %s.\n",
                            minionName, villainName);
                }

                conn.commit();

            } catch (SQLException se) {
                try {
                    conn.rollback();
                    conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        } catch (SQLException | IOException e) {
            System.out.println("Unknown error. Please try again :)");
        }
    }

    private static void addUniqueIndex(Connection conn) throws SQLException {
        PreparedStatement dropIfExists = conn.prepareStatement(
                "DROP PROCEDURE IF EXISTS make_names_unique;");
        dropIfExists.executeUpdate();
        PreparedStatement makeNamesUnique = conn.prepareStatement(
                "CREATE PROCEDURE make_names_unique()\n" +
                        "BEGIN\n" +
                        "\tALTER TABLE towns ADD UNIQUE(town_name);\n" +
                        "\tALTER TABLE villains ADD UNIQUE(villain_name);\n" +
                        "\tALTER TABLE minions ADD UNIQUE(minion_name);\n" +
                        "END;");
        makeNamesUnique.executeUpdate();
        CallableStatement callMakeNamesUnique = conn.prepareCall(
                "CALL make_names_unique();");
        callMakeNamesUnique.executeUpdate();
    }

}
