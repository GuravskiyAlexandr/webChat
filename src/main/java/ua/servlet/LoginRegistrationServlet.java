package ua.servlet;


import ua.data.ListUsers;
import ua.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class LoginRegistrationServlet extends HttpServlet {
    private ListUsers classUserList = ListUsers.getClassUserList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login.length() > 2 && password.length() > 2) {
            if (!classUserList.checkUserLog(login)) {
                HttpSession session = request.getSession(true);
                session.setMaxInactiveInterval(15);
                session.setAttribute("user_login", login);
                Thread thread = new Thread(new OnlineListUser(login));
                thread.isDaemon();
                User user = new User(login, password, new Date(), session, thread);
                classUserList.setUserNameList(login);
                classUserList.setMapLoginAngUser(login, user);
                thread.start();
                response.sendRedirect("chat.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sessionUser = request.getParameter("session");
        HttpSession session = request.getSession(false);

        String login = (String) session.getAttribute("user_login");
        System.out.println(login + "   user_login");
        if ("exit".equals(sessionUser)) {
            session.removeAttribute("user_login");
            session.invalidate();
            session = null;
            classUserList.getMapLoginAngUser().get(login).setHttpSession(session);
            for (int i = 0; i < classUserList.getListUsers().size(); i++) {
                String name = (String) classUserList.getListUsers().get(i);
                if (login.equals(name)) {
                    User user = classUserList.getMapLoginAngUser().get(name);
                    user.setHttpSession(session);
                    user.getThread().interrupt();
                    classUserList.setMapLoginAngUser(name, user);
                }
            }
        }
        response.sendRedirect("index.jsp");
    }
}
