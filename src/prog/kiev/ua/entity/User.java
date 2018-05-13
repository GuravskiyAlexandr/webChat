package prog.kiev.ua.entity;/*
 * Created by Alexsandr        03.05.2018
 */

import javax.jms.Session;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class User {
    String login;
    String password;
    Date date;
    HttpSession httpSession;


    public User(String login, String password, Date date, HttpSession httpSession) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.httpSession = httpSession;
    }

    public User(HttpSession session) {

    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", httpSession=" + httpSession +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }

    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }
}
