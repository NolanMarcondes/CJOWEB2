import java.sql.*;

public class TaskDao {
    private Connection conn;

    public TaskDao(Connection conn) {
        this.conn = conn;
    }

    public void save(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (description, date, user_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, task.getDescription());
        stmt.setDate(2, new java.sql.Date(task.getDate().getTime()));
        stmt.setInt(3, task.getUser().getId());
        stmt.executeUpdate();
    }
}