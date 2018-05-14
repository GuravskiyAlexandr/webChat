package prog.kiev.ua.data;



import prog.kiev.ua.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListUsers {
    private static final ListUsers classUserList = new ListUsers();
    private List<User> userList = new ArrayList<>();
    private HashMap<String, User> mapLoginAngUser = new HashMap<>();

    public HashMap<String, User> getMapLoginAngUser() {
        return mapLoginAngUser;
    }

    public void setMapSession(String user, User session) {
        mapLoginAngUser.put(user, session);
    }

    public static ListUsers getClassUserList() {
        return classUserList;
    }

    public ListUsers(List<User> list) {
        this.userList = list;
    }

    public ListUsers(){
    }
    public boolean checkUserLog(String log){
        if (userList.stream().anyMatch((s)-> (s.getLogin().equals(log))) ) return true;
        return false;
    }

    public boolean checkUsersPass(String pass) {
        if (userList.stream().anyMatch((s)-> (s.getPassword().equals(pass))))return true;
        return false;
    }

    public synchronized void  addUser(User user) {
        userList.add(user);
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
