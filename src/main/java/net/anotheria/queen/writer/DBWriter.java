package net.anotheria.queen.writer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class DBWriter implements IWriter {


    private int fieldCounter;

    /**
     * Write positions into the database.
     *
     * @param positions queens combination.
     */
    @Override
    public void write(int[] positions) {

        Connection connection = connect();

        String result = Arrays.toString(positions);
        fieldCounter++;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO positions (coordinates,field_counter) VALUES (?,?)");
            ps.setString(1, result);
            ps.setInt(2, fieldCounter);
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/queens", "postgres", "savelichev");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }


}
