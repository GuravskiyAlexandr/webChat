package prog.kiev.ua.servlet;/*
 * Created by Alexsandr        12.05.2018
 */

import prog.kiev.ua.data.ListUsers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class  LoginServlet extends HttpServlet {
    private ListUsers classUserList = ListUsers.getClassUserList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (classUserList.checkUserLog(login, password)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user_login", login);
                classUserList.getMapLoginAngUser().get(login).setHttpSession(session);
                response.sendRedirect("chat.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }


    }
}