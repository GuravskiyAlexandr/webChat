<%@ page import="java.util.List" %>
<%@ page import="ua.entity.User" %>
<%@ page import="ua.entity.Message" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

</head>
<body>

<h1>Chat</h1>

<% String login = (String) session.getAttribute("user_login"); %>
<H2> you login <%=login%>
</H2>

<% if (login == null || "".equals(login)) { %>
<div style="display: flex; justify-content: center; align-items: center; height: 350px; flex-direction: column;
    padding: 25px;">
    <div style="background-color: #b7b1f1; padding: 20px;">
        <h1 style="padding: 20px"> Need Sign Up</h1>
        <a href="index.jsp">Sign Up</a>
    </div>
        <% } else { %>
    <div style="display: flex">
        <div style="width: 300px; height: 400px; border: red solid 2px">
            <% List<User> listUser = (List) session.getAttribute("users"); %>
            <% if (listUser != null) {
                for (Object s : listUser) {%>
            <% User user = (User) s;%>
            <form style="margin: 0px;" action="/check?login=<%=login%>" method="POST">
                <input style="color:<%=user.getColor()%>;
                        opacity:<%=user.getOpasity()%>;font-size: 30px;
                        border-style: none;
                        background: #f9b8b8;
                        height: 40px;
                        width: 300px;
                        text-align: left; border-bottom-style: outset; " type="submit" value="<%=user.getLogin()%>"
                       name="userName">
            </form>
            <% }
            }%>
        </div>
        <div style=" overflow-y: auto; width: 500px; height: 400px; border: red solid 2px">
            <%String toWhom = (String) session.getAttribute("toWhom");%>
            <% if (toWhom == null || "".equals(toWhom)) { %>
            <%
                    toWhom = "all";
                }
            %>
            <h3>
                You write <%if (!toWhom.equals(""))%><%=toWhom%>
            </h3>

            <% List<Message> list = (List) session.getAttribute("sms"); %>
            <% if (list != null) {
                for (Object o : list) {%>
            <% Message message = (Message) o;%>
            <%if (toWhom.equals("all")) {%>
            <%if (message.getTo().equals("all") && toWhom.equals(message.getTo())) {%>
            <p><%=message%>
            </p>
            <%}%>
            <%}%>
            <%
                if (!message.getTo().equals("all") && message.getFrom().equals(login)
                        && message.getTo().equals(toWhom) || login.equals(message.getTo()) && toWhom.equals(message.getFrom())) {%>
            <P><%=message%>
            </p>
            <%}%>
            <% }
            }%>
        </div>
        <div>
            <a href="index.jsp"> MAIN PAGE</a>
            <form style="margin: 0px;" action="/check?login=<%=login%>&userName=all" method="POST">
                <input style="font-size: 30px;
                        border-style: none;
                        background: #f9b8b8;
                        height: 40px;
                        width: 300px;
                        text-align: left; border-bottom-style: outset; " type="submit" value="Write ALL Users"
                       name="userName">
            </form>
        </div>
    </div>
    <div>
        <form action="/send?login=<%=login%>" method="post" style="display:flex; width: 710px">
            <%--pattern="[A-Za-z0-9_-]{4,8}"--%>
            <input placeholder="Write a message"
                   style="font-size: 40px; width: 710px; height: 100px;border: blue solid;" type="text" name="textSend">
            <input type="submit"/>
        </form>
    </div>
        <% } %>

</body>
</html>
