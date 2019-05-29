package service;

import dao.Entity_CRUD;
import entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskService implements Entity_CRUD<Task> {

    private Connection connection;

    public TaskService(Connection connection) {
        this.connection = connection;
    }

    public void create(Task task) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "INSERT INTO \"TASKS\" " +
                "(\"ID\", \"NAME\", \"DESCRIPTION\", completed,\"IMPORTANCE_ID\", \"REMINDER_ID\") " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,task.getId());
            preparedStatement.setString(2,task.getName());
            preparedStatement.setString(3,task.getDescription());
            preparedStatement.setBoolean(4,task.getCompleted());
            preparedStatement.setLong(5,task.getImportance_id());
            preparedStatement.setLong(6,task.getReminder_id());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Task> getAll() {
        List<Task> tasks = new ArrayList<>();

        if (connection == null) {
            return tasks;
        }

        String sqlQuery = "SELECT * FROM \"TASKS\"";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getLong("ID"));
                task.setName(resultSet.getString("NAME"));
                task.setDescription(resultSet.getString("DESCRIPTION"));
                task.setCompleted(resultSet.getBoolean("COMPLETED"));
                task.setReminder_id(resultSet.getLong("REMINDER_ID"));
                task.setImportance_id(resultSet.getLong("IMPORTANCE_ID"));
                tasks.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public Task getByID(Long ID) {
        Task task = null;

        if (connection == null) {
            return task;
        }

        String sqlQuery = "SELECT * FROM \"TASKS\" WHERE ID = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,ID);

            ResultSet resultSet = preparedStatement.executeQuery();

            task = new Task();
            task.setId(resultSet.getLong("ID"));
            task.setName(resultSet.getString("NAME"));
            task.setDescription(resultSet.getString("DESCRIPTION"));
            task.setCompleted(resultSet.getBoolean("COMPLETED"));
            task.setReminder_id(resultSet.getLong("REMINDER_ID"));
            task.setImportance_id(resultSet.getLong("IMPORTANCE_ID"));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return task;
    }

    public void update(Task task) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "UPDATE \"TASKS\" " +
                "SET \"NAME\"=?, \"DESCRIPTION\"=?, completed=?,\"IMPORTANCE_ID\"=?, \"REMINDER_ID\"=? " +
                "WHERE \"ID\"=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

            preparedStatement.setString(1,task.getName());
            preparedStatement.setString(2,task.getDescription());
            preparedStatement.setBoolean(3,task.getCompleted());
            preparedStatement.setLong(4,task.getImportance_id());
            preparedStatement.setLong(5,task.getReminder_id());
            preparedStatement.setLong(6,task.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Task task) {
        if (connection == null) {
            return;
        }

        String sqlQuery = "DELETE FROM \"TASKS\" WHERE \"ID\"=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1,task.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
