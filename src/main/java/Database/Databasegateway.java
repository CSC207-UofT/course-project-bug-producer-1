package net.codejava;

import java.io.*;
import java.sql.*;

public class Database {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/sales";
        String username = "user";
        String password = "password";

        String csvFilePath = "Reviews-simple.csv";

        int batchSize = 20;

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO review (Itemname, capacity) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine(); // skip header line

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String itemname = data[0];
                String capacity = data[1];

                statement.setString(1, itemname);
                statement.setString(2, capacity);

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();

            statement.executeBatch();

            connection.commit();
            connection.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
