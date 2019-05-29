package service;

import dao.ImportanceDAO;
import entity.Importance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return null;
    }

    @Override
    public Importance getByID(long ID) {
        return null;
    }

    @Override
    public void update(Importance importance) {

    }

    @Override
    public void remove(Importance importance) {

    }
}
