import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Engine {

    private Connection connection;
    private BufferedReader reader;

    public Engine(Connection connection) {
        this.connection = connection;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void run() {
        //this.getVillainsNames();
        //this.getMinionNames();
        //this.addMinion();
    }

    /**
     * Problem 1. Get Villains’ Names
     */
    private void getVillainsNames() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "SELECT name AS villain_name, COUNT(minions_villains.minion_id) AS minions_count FROM villains INNER JOIN minions_villains ON villains.id = minions_villains.villain_id GROUP BY minions_villains.villain_id HAVING minions_count > ? ORDER BY minions_count DESC";

        try {
            preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, 15);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(String.format("%s %d", resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) { try { preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();}}
            if (resultSet != null) { try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}}

        }
    }

    /**
     * Problem 2. Get Minion Names
     */
    private void getMinionNames() {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        int villainId = -1;
        try {
            villainId = Integer.parseInt(this.reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!this.contains("villains", villainId)) {
            System.out.println(String.format("No villain with id %d exists in the database.", villainId));
            return;
        }

        String qry = "SELECT v.name AS villain_name, m.name AS minion_name, m.age FROM minions AS m INNER JOIN minions_villains AS mv ON m.id = mv.minion_id INNER JOIN villains AS v ON mv.villain_id = v.id WHERE v.id = ?";

        try {
            preparedStatement = this.connection.prepareStatement(qry);
            preparedStatement.setInt(1, villainId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println(String.format("Villain: %s", resultSet.getString("villain_name")));
            }

            int i = 1;

            while (resultSet.next()) {
                System.out.println(String.format("%d. %s %d", i, resultSet.getString(2), resultSet.getInt(3)));
                i++;
            }

            if (i == 1) {
                System.out.println("<no minions>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) { try { preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();}}
            if (resultSet != null) { try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}}

        }
    }

    /**
     * Problem 3. Add Minion
     */
    private void addMinion() {
        try {
            String[] minionData = reader.readLine().split(" ");
            String villainName = reader.readLine();

            String minionName = minionData[0];
            int minionAge = Integer.parseInt(minionData[1]);
            String town = minionData[2];

            if (!this.contains("towns", town)) {
                this.insertTown(town);
            }

            int townId = this.getTownId(town);

            if (!this.contains("villains", villainName)) {
                // insert villain
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getTownId(String townName) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        int id = -1;

        String qry = "SELECT id FROM towns WHERE name = ?";

        try {
            this.connection.prepareStatement(qry);
            preparedStatement.setString(1, townName);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) { try { preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();}}
            if (resultSet != null) { try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}}

        }

        return id;
    }

    private void insertTown(String townName) {

        PreparedStatement preparedStatement = null;

        String qry = "INSERT INTO towns (name) VALUES (?)";

        try {
            preparedStatement = this.connection.prepareStatement(qry);
            preparedStatement.setString(1, townName);

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) { try { preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();}}
        }
    }

    private boolean contains(String tableName, int id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String qry = "SELECT * FROM " + tableName + " WHERE id = ?";

        try {
            preparedStatement = this.connection.prepareStatement(qry);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) { try { preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();}}
            if (resultSet != null) { try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}}

        }

        return false;
    }

    private boolean contains(String tableName, String name) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String qry = "SELECT * FROM " + tableName + " WHERE name = ?";

        try {
            preparedStatement = this.connection.prepareStatement(qry);
            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) { try { preparedStatement.close(); } catch (SQLException e) {e.printStackTrace();}}
            if (resultSet != null) { try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}}
        }

        return false;
    }
}
