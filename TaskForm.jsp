<% User user = (User) session.getAttribute("user");
   if (user == null) {
       response.sendRedirect("login.jsp");
       return;
   }
%>
<form action="registerTask" method="post">
    Descrição: <input type="text" name="description"><br>
    Data: <input type="date" name="date"><br>
    <input type="submit" value="Cadastrar Tarefa">
</form>