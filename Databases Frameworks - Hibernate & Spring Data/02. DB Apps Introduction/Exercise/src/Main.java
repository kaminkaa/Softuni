import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String connectionString = "jdbc:mysql://localhost:3306/minions_db";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionString, "root", "N@cheva93");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Engine engine = new Engine(connection);

        engine.run();

    }
}
