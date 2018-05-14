package prog.kiev.ua.servlet;/*
 * Created by Alexsandr        13.05.2018
 */

import prog.kiev.ua.data.ListUsers;
import prog.kiev.ua.data.MessageList;
import prog.kiev.ua.entity.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SMSServlet extends HttpServlet {
    private ListUsers classUserList = ListUsers.getClassUserList();
    private MessageList messageList = MessageList.getClassMsgList();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String text = request.getParameter("textSend");
        HttpSession session = classUserList.getMapLoginAngUser().get(login).getHttpSession();
        List list = new ArrayList();
        if (session != null) {
            Message message = new Message(login, text);
            messageList.getList().add(message);
            if (messageList.getList() != null) {
                session.setAttribute("sms", messageList.getList());
                for (Object obj : classUserList.getListUsers()) {
                    String name = (String) obj;
                    String color;
                    if (classUserList.getMapLoginAngUser().get(name).getHttpSession()!= null){
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
}
