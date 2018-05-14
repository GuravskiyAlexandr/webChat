package prog.kiev.ua.servlet;


import prog.kiev.ua.data.ListUsers;
import prog.kiev.ua.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class LoginRegistrationServlet extends HttpServlet {
    private ListUsers listUsers = ListUsers.getClassUserList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login.length() > 2 && password.length() > 2) {
            if (!listUsers.checkUserLog(login)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user_login", login);
                User user = new User(login, password, new Date(), session);
                listUsers.getListUsers().add(user);
                listUsers.setMapSession(login, user);
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
        if ("exit".equals(sessionUser) && (session != null)) {
            session.removeAttribute("user_login");
            session.invalidate();
            session = null;
            listUsers.getMapLoginAngUser().get(login).setHttpSession(session);
            for (int i = 0; i < listUsers.getListUsers().size(); i++) {
                User s = (User) listUsers.getListUsers().get(i);
                if (login.equals(s.getLogin())) {

                    s.setHttpSession(session);
                    listUsers.getListUsers().set(i, s);
                }
            }
            for (int i = 0; i < listUsers.getListUsers().size(); i++) {
                User s = (User) listUsers.getListUsers().get(i);
            }
        }
        response.sendRedirect("index.jsp");
    }
}
