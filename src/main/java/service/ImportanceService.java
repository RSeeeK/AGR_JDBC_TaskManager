package service;

import dao.ImportanceDAO;
import entity.Importance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImportanceService implements ImportanceDAO {
    private Connection connection;

    public ImportanceService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Importance importance) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "INSERT INTO \"IMPORTANCE\" " +
                "(\"ID\", \"NAME\") " +
                "VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,importance.getId());
            preparedStatement.setString(2,importance.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Importance> getAll() {
        List<Importance> importanceList = new ArrayList<>();

        if (connection == null) {
            return importanceList;
        }

        String sqlQuery = "SELECT * FROM \"IMPORTANCE\"";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Importance importance = new Importance();
                importance.setId(resultSet.getLong("ID"));
                importance.setName(resultSet.getString("NAME"));
                importanceList.add(importance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return importanceList;
    }

    @Override
    public Importance getByID(long ID) {
        Importance importance = null;

        if (connection == null) {
            return importance;
        }

        String sqlQuery = "SELECT * FROM \"TASKS\" WHERE ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            importance = new Importance();
            importance.setId(resultSet.getLong("ID"));
            importance.setName(resultSet.getString("NAME"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return importance;
    }

    @Override
    public void update(Importance importance) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "UPDATE \"IMPORTANCE\" " +
                "SET \"NAME\"=? " +
                "WHERE \"ID\"=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1,importance.getName());
            preparedStatement.setLong(2,importance.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Importance importance) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "DELETE FROM \"IMPORTANCE\" WHERE \"ID\"=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,importance.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
