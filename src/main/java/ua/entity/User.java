package ua.entity;/*
 * Created by Alexsandr        03.05.2018
 */

import javax.servlet.http.HttpSession;
import java.util.Date;

public class User {
    private String login;
    private String password;
    private Date date;
    private HttpSession httpSession;
    private Thread thread;
    private String color;
    private String opasity;
    private String toWhom = "all";



    public User(String login, String password, Date date, HttpSession httpSession, Thread thread) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.httpSession = httpSession;
        this.thread = thread;

    }

    public User( String name, String color, String opacity) {
        this.login = name;
        this.color = color;
        this.opasity = opacity;

    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", httpSession=" + httpSession +
                ", thread=" + thread +
                '}';
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOpasity() {
        return opasity;
    }

    public void setOpasity(String opasity) {
        this.opasity = opasity;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
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
