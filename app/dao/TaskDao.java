package dao;

import models.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import play.db.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Sigurd Stendal
 * Date: 01.02.13
 */
public class TaskDao {

    static JdbcTemplate jdbcTemplate = new JdbcTemplate(DB.getDataSource());

    public static List<Task> all() {
        return jdbcTemplate.query("select * from tasks", new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet resultSet, int i) throws SQLException {
                Task task = new Task();
                task.id = resultSet.getLong("id");
                task.label = resultSet.getString("label");
                return task;
            }
        });
    }


    public static void create(Task task) {
        jdbcTemplate.update("insert into tasks (label) values(?)", task.label);
    }

    public static void delete(Long id) {
        jdbcTemplate.update("delete from tasks where id = ?", id);
    }
}
