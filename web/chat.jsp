<%@ page import="prog.kiev.ua.entity.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Alexsandr
  Date: 13.05.2018
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Chat</h1>

<% String login = (String) session.getAttribute("user_login"); %>

<% if (login == null || "".equals(login)) { %>
<div style="display: flex; justify-content: center; align-items: center; height: 350px; flex-direction: column;
    padding: 25px;">
    <div style="background-color: #b7b1f1; padding: 20px;">
        <h1 style="padding: 20px"> Need Sign Up</h1>
    </div>
        <% } else { %>
    <div style="display: flex">
        <div style="width: 200px; height: 600px; border: red solid 2px">
            <% List listUser = (List) session.getAttribute("users"); %>
            <% if (listUser != null){
                for (Object s: listUser){%>
            <%=s%>
            <% }}%>
        </div>
        <div style="width: 500px; height: 600px; border: red solid 2px">
            <% List list = (List) session.getAttribute("sms"); %>
            <% if (list != null){
             for (Object s: list){%>
                <%=s%>
            <br>
           <% }}%>

        </div>
        <div> <a href="index.jsp"> MAIN PAGE</a> </div>
    </div>
    <div>
        <form action="/send?login=<%=login%>" method="post" style="display:flex; width: 710px">
            <input placeholder="Write a message"
                   style="font-size: 40px; width: 710px; height: 100px;border: blue solid;" type="text" name="textSend">
            <input type="submit"/>
        </form>
    </div>
        <% } %>

</body>
</html>
