package models;

import dao.TaskDao;
import play.data.validation.Constraints.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Sigurd Stendal
 * Date: 01.02.13
 */
public class Task {

    public Long id;

    @Required
    public String label;

    public static List<Task> all() {
        return TaskDao.all();
    }

    public static void create(Task task) {
        TaskDao.create(task);
    }

    public static void delete(Long id) {
        TaskDao.delete(id);
    }
}
