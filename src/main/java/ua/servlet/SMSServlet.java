package ua.servlet;/*
 * Created by Alexsandr        13.05.2018
 */

import ua.data.ListUsers;
import ua.data.MessageList;
import ua.entity.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMSServlet extends HttpServlet {
    private ListUsers classUserList = ListUsers.getClassUserList();
    private MessageList classMsgList = MessageList.getClassMsgList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String text = request.getParameter("textSend");
        String to = classUserList.getMapLoginAngUser().get(login).getToWhom();
        System.out.println(to + "  to "+login+ "  login" );
        HttpSession session = request.getSession();


        Message message = new Message(login, text, to);
        classMsgList.getList().add(message);
        if (classMsgList.getList() != null) {
            session.setAttribute("sms", classMsgList.getList());
            request.setCharacterEncoding("UTF-8");
            response.sendRedirect("chat.jsp");
        }

    }
}