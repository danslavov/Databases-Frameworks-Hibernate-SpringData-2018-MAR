package T06_DBApps.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter username: ");
        String username = reader.readLine();
        System.out.print("Enter password: ");
        String password = reader.readLine();
        System.out.print("Enter database: ");
        String db = reader.readLine();

        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/".concat(db), props);

        PreparedStatement ps = conn.prepareStatement(
                "SELECT \n" +
                        "    u.user_name, u.first_name, u.last_name, COUNT(*) AS game_count\n" +
                        "FROM\n" +
                        "    users AS u\n" +
                        "        JOIN\n" +
                        "    users_games AS ug ON u.id = ug.user_id\n" +
                        "        JOIN\n" +
                        "    games AS g ON ug.game_id = g.id\n" +
                        "WHERE\n" +
                        "    u.user_name = ?\n" +
                        "GROUP BY u.user_name;"
        );

        System.out.print("Enter diablo username: ");
        String diabloUsername = reader.readLine();
        ps.setString(1, diabloUsername);
        ResultSet rs = ps.executeQuery();

        if (rs.isBeforeFirst()) {
            while (rs.next()) {
                System.out.printf(
                        "user_name: %s\nfirst name: %s\n" +
                                "last name: %s\ngame count: %d\n",
                        rs.getString("user_name"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("game_count"));
            }
        } else {
            System.out.println("No such user exists");
        }
    }
}
