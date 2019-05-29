package service;

import dao.RemindersDAO;
import entity.Reminders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RemindersService implements RemindersDAO {
    private Connection connection;

    public RemindersService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Reminders reminder) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "INSERT INTO \"REMINDERS\" " +
                "(\"ID\", \"DESCRIPTION\", \"REMINDER_TIME\") " +
                "VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,reminder.getId());
            preparedStatement.setString(2,reminder.getDescription());
            preparedStatement.setDate(3,reminder.getReminderTime());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Reminders> getAll() {
        return null;
    }

    @Override
    public Reminders getByID(long ID) {
        return null;
    }

    @Override
    public void update(Reminders tasks) {

    }

    @Override
    public void remove(Reminders tasks) {

    }
}
