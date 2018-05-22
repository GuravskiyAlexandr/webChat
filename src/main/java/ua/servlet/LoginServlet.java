package ua.servlet;

import ua.data.ListUsers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private ListUsers classUserList = ListUsers.getClassUserList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (classUserList.checkUserLog(login, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
            classUserList.getMapLoginAngUser().get(login).setHttpSession(session);
            Thread thread = new Thread(new OnlineListUser(login));
            thread.isDaemon();
            thread.start();
            classUserList.getMapLoginAngUser().get(login).setThread(thread);
            response.sendRedirect("chat.jsp");
            System.out.println(session.getAttributeNames());
        } else {
            response.sendRedirect("index.jsp");
        }


    }
}