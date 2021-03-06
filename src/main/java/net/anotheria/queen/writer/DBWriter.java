package net.anotheria.queen.writer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Write result into database.
 */
public class DBWriter implements IWriter {


    /**
     * Counter of combinations.
     */
    private int combinationCounter;

    /**
     * Write positions into the database.
     *
     * @param positions queens combination.
     */
    @Override
    public void write(int[] positions) {

        Connection connection = connect();

        String result = Arrays.toString(positions);
        combinationCounter++;

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO positions (coordinates,field_counter) VALUES (?,?)");
            ps.setString(1, result);
            ps.setInt(2, combinationCounter);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection connect() {

        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queens", "postgres", "savelichev");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }


}
