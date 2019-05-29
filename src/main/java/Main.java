import entity.Task;
import service.TaskService;
import util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Util.getConnection()) {
            TaskService taskService = new TaskService(connection);
//            Task secondTask = new Task();
//            secondTask.setId(2);
//            secondTask.setCompleted(false);
//            secondTask.setName("Test2");
//            secondTask.setDescription("tru la la la");
//            secondTask.setImportance_id(2);
//            secondTask.setReminder_id(1);
//
//            taskService.add(secondTask);
//            taskService.update(secondTask);
//            taskService.remove(secondTask);

            List<Task> tasks = taskService.getAll();
            for (Task task:
                 tasks) {
                System.out.println(task);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
