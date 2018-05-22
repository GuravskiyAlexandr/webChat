package ua.servlet;/*
 * Created by Alexsandr        20.05.2018
 */

import ua.data.ListUsers;
import ua.data.MessageList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckServlet extends HttpServlet {
    private ListUsers classUserList = ListUsers.getClassUserList();
    private MessageList classMessageList = MessageList.getClassMsgList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String to = request.getParameter("userName");
        String login = request.getParameter("login");
        classUserList.getMapLoginAngUser().get(login).getHttpSession().setAttribute("toWhom", to);
        classUserList.getMapLoginAngUser().get(login).setToWhom(to);

        HttpSession session = request.getSession();
        if (classMessageList.getList() != null) {
            session.setAttribute("sms", classMessageList.getList());
            request.setCharacterEncoding("UTF-8");
            response.sendRedirect("chat.jsp");
        }
    }
}
