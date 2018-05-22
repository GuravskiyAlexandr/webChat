package ua.servlet;/*
 * Created by Alexsandr        20.05.2018
 */

import ua.data.ListUsers;
import ua.entity.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnlineListUser implements Runnable {
    private ListUsers classListUsers = ListUsers.getClassUserList();
    private User user;
    private String login;

    public OnlineListUser(String login) {
        this.login  =login;
    }

    @Override
    public void run() {

        while (!classListUsers.getMapLoginAngUser().get(login).getThread().isInterrupted()) {
            List<User> list = new ArrayList<>();
            for (Object o : classListUsers.getListUsers()) {
                String name = (String) o;
                user = classListUsers.getMapLoginAngUser().get(name);
                if (user.getHttpSession() != null) {
                    user.setColor("red");
                    user.setOpasity("1");
                } else {
                    user.setColor("black");
                    user.setOpasity("0.5");
                }
                list.add(user);
                if (user.getHttpSession() != null) {
                    try {
                        Date dateLast = new Date(user.getHttpSession().getLastAccessedTime());
                        Date dateNow = new Date();
                        if ((dateNow.getTime() - dateLast.getTime()) > 1000* 15){
                            classListUsers.getMapLoginAngUser().get(name).setHttpSession(null);
                        }else {
                            user.getHttpSession().setAttribute("users", list);
                        }
                    }catch (Exception e){
                        classListUsers.getMapLoginAngUser().get(name).setHttpSession(null);
                        e.getStackTrace();
                    }

                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
