<%--
  Created by IntelliJ IDEA.
  User: Alexsandr
  Date: 12.05.2018
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String login = (String) session.getAttribute("user_login"); %>

<% if (login == null || "".equals(login)) { %>

<div style="display: flex; justify-content: center; align-items: center; height: 350px; flex-direction: column;
    padding: 25px;">

    <div style="background-color: #b7b1f1; padding: 20px;">
        <h1 style="padding: 20px">Login to your account</h1>
        <form action="/chat" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit"/>
        </form>
    </div>
        <% } else { %>
    <h1>Chat</h1>
    <div style="display: flex">
        <h1> <a href="chat.jsp">go to chat</a> </h1>


    </div>
        <% } %>

</body>
</html>
