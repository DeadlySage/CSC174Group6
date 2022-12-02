import java.sql.*;
import java.net.URI;
import java.net.URISyntaxException;

public class database {
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        
        return DriverManager.getConnection("jdbc:postgresql://ec2-44-206-214-233.compute-1.amazonaws.com:5432/dauvj6cug04ef3", "ulvjtygofxqhug", "855e7b41909eda167fbea7bbebb1bcf1e5947c40537ae8720703b83443599617");
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