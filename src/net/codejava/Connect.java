package src.net.codejava;

import java.sql.*;
import java.net.URISyntaxException;

public class Connect {

    private static Connection getConnection() throws URISyntaxException, SQLException {

        return DriverManager.getConnection("jdbc:postgresql://ec2-52-200-215-149.compute-1.amazonaws.com:5432/d1tr1n3ekn8mdu"
                , "swuniiavovtunb", "231f83fcf439fbd4ecc3cd71558f9b4151ab54ef560e79cb5dd24cc5d168c6f1");
    }

    public static void main(String[] args) throws URISyntaxException, SQLException {
        String query = "SELECT * FROM Pokemon_List";

        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String pokemonID = rs.getString("id");
                System.out.println(pokemonID);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}