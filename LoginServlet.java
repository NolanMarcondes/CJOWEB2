public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (Connection conn = Database.getConnection()) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UserDao userDao = new UserDao(conn);
            User user = userDao.authenticate(email, password);

            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect("taskForm.jsp");
            } else {
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
