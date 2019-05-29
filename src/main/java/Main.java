import entity.Tasks;
import service.TasksService;
import util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = Util.getConnection()) {
            TasksService tasksService = new TasksService(connection);
//            Tasks secondTask = new Tasks();
//            secondTask.setId(2);
//            secondTask.setCompleted(false);
//            secondTask.setName("Test2");
//            secondTask.setDescription("tru la la la");
//            secondTask.setImportance_id(2);
//            secondTask.setReminder_id(1);
//
//            tasksService.add(secondTask);
//            tasksService.update(secondTask);
//            tasksService.remove(secondTask);

            List<Tasks> tasks = tasksService.getAll();
            for (Tasks task:
                 tasks) {
                System.out.println(task);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
