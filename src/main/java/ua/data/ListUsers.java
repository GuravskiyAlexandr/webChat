package ua.data;



import ua.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUsers {
    private static final ListUsers classUserList = new ListUsers();
    private List<String> userNameList = new ArrayList<>();
    private Map<String, User> mapLoginAngUser = new HashMap<>();

    public Map<String, User> getMapLoginAngUser() {
        return mapLoginAngUser;
    }

    public synchronized   void   setMapLoginAngUser(String user, User session) {
        mapLoginAngUser.put(user, session);
    }

    public synchronized void setUserNameList(String name) {
        userNameList.add(name);
    }

    public static ListUsers getClassUserList() {
        return classUserList;
    }

    public ListUsers(List<String> list) {
        this.userNameList = list;
    }

    public ListUsers(){
    }
    public boolean checkUserLog(String log){
        if (userNameList.stream().anyMatch((s)-> (s.equals(log))) ) return true;
        return false;
    }

    public boolean checkUsersPass(String pass) {
        if (userNameList.stream().anyMatch((s)-> (s.equals(pass))))return true;
        return false;
    }

    public List getListUsers() {
       return userNameList;
    }

    public boolean checkUserLog(String login, String password) {
        if (mapLoginAngUser.containsKey(login))
        if (password.equals(mapLoginAngUser.get(login).getPassword()))return true;
        return false;
    }
}
