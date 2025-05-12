@WebServlet("/registerTask")
public class RegisterTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (Connection conn = Database.getConnection()) {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }

            Task task = new Task();
            task.setDescription(request.getParameter("description"));
            task.setDate(java.sql.Date.valueOf(request.getParameter("date")));
            task.setUser(user);

            TaskDao taskDao = new TaskDao(conn);
            taskDao.save(task);
            response.sendRedirect("taskForm.jsp?success=1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}