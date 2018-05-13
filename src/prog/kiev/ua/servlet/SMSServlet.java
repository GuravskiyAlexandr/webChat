package prog.kiev.ua.servlet;/*
 * Created by Alexsandr        13.05.2018
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import prog.kiev.ua.data.ListUsers;
import prog.kiev.ua.data.MessageList;
import prog.kiev.ua.entity.Message;
import prog.kiev.ua.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SMSServlet extends HttpServlet {
    private ListUsers listUsers = ListUsers.getUsrList();
    private MessageList messageList = MessageList.getMsgList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String text = request.getParameter("textSend");

        HttpSession session = listUsers.getMapLoginAngUser().get(login).getHttpSession();
        List list = new ArrayList();
        if (session != null) {
            Message message = new Message(login, text);
            messageList.getList().add(message);
            if (messageList.getList() != null) {
                session.setAttribute("sms", messageList.getList());
                System.out.println(login+ " " + listUsers.getListUsers());
                for (Object obj : listUsers.getListUsers()) {
                    User user = (User) obj;
                    String color;
                    String name = user.getLogin();
                    if (user.getHttpSession() != null){
                        color = "green";
                    }else {
                        color = "black";
                    }

                    list.add("<p style=' font-size: 25px; color:"+ color +"'>"+name+"</P>");

                    session.setAttribute("users", list );
                }
                response.sendRedirect("chat.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String sessionUser = request.getParameter("session");
        HttpSession session = request.getSession(false);
        if ("exit".equals(sessionUser) && (session != null))
            session.removeAttribute("user_login");
        response.sendRedirect("index.jsp");
    }
}
