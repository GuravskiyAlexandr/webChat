package prog.kiev.ua.data;



import prog.kiev.ua.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListUsers {
    private static final ListUsers classUserList = new ListUsers();
    private List<String> userList = new ArrayList<>();
    private Map<String, User> mapLoginAngUser = new HashMap<>();

    public Map<String, User> getMapLoginAngUser() {
        return mapLoginAngUser;
    }

    public void setMapLoginAngUser(String user, User session) {
        mapLoginAngUser.put(user, session);
    }

    public static ListUsers getClassUserList() {
        return classUserList;
    }

    public ListUsers(List<String> list) {
        this.userList = list;
    }

    public ListUsers(){
    }
    public boolean checkUserLog(String log){
        if (userList.stream().anyMatch((s)-> (s.equals(log))) ) return true;
        return false;
    }

    public boolean checkUsersPass(String pass) {
        if (userList.stream().anyMatch((s)-> (s.equals(pass))))return true;
        return false;
    }

    public List getListUsers() {
       return userList;
    }

    public boolean checkUserLog(String login, String password) {
        if (mapLoginAngUser.containsKey(login))
        if (password.equals(mapLoginAngUser.get(login).getPassword()))return true;
        return false;
    }
}
