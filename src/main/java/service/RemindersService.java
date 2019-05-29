package service;

import dao.RemindersDAO;
import entity.Reminders;

import java.sql.*;
import java.util.ArrayList;
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
        List<Reminders> reminders = new ArrayList<>();

        if (connection == null) {
            return reminders;
        }

        String sqlQuery = "SELECT * FROM \"REMINDERS\"";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Reminders reminder = new Reminders();
                reminder.setId(resultSet.getLong("ID"));
                reminder.setReminderTime(resultSet.getDate("NAME"));
                reminder.setDescription(resultSet.getString("DESCRIPTION"));
                reminders.add(reminder);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reminders;
    }

    @Override
    public Reminders getByID(long ID) {
        Reminders reminder = null;

        if (connection == null) {
            return reminder;
        }

        String sqlQuery = "SELECT * FROM \"REMINDERS\" WHERE ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            reminder = new Reminders();
            reminder.setId(resultSet.getLong("ID"));
            reminder.setDescription(resultSet.getString("DESCRIPTION"));
            reminder.setReminderTime(resultSet.getDate("REMINDER_TIME"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reminder;
    }

    @Override
    public void update(Reminders reminder) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "UPDATE \"REMINDERS\" " +
                "SET  \"DESCRIPTION\"=?, \"REMINDER_TIME\"=? " +
                "WHERE \"ID\"=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1,reminder.getDescription());
            preparedStatement.setDate(2,reminder.getReminderTime());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void remove(Reminders reminder) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "DELETE FROM \"REMINDERS\" WHERE \"ID\"=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,reminder.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
