package prog.kiev.ua.data;



import prog.kiev.ua.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListUsers {
    private static final ListUsers usrList = new ListUsers();
    private List<User> list = new ArrayList<>();
    private HashMap<String, User> mapLoginAngUser = new HashMap<>();

    public HashMap<String, User> getMapLoginAngUser() {
        return mapLoginAngUser;
    }

    public void setMapSession(String user, User session) {
        mapLoginAngUser.put(user, session);
    }

    public static ListUsers getUsrList() {
        return usrList;
    }

    public ListUsers(List<User> list) {
        this.list = list;
    }

    public ListUsers(){
    }
    public boolean checkUserLog(String log){
        if (list.stream().anyMatch((s)-> (s.getLogin().equals(log))) ) return true;
        return false;
    }

    public boolean checkUsersPass(String pass) {
        if (list.stream().anyMatch((s)-> (s.getPassword().equals(pass))))return true;
        return false;
    }

    public synchronized void  addUser(User user) {
        list.add(user);
    }

    public List getListUsers() {
       return list;
    }

    public boolean checkUserLog(String login, String password) {
        if (mapLoginAngUser.containsKey(login))
        if (password.equals(mapLoginAngUser.get(login).getPassword()))return true;
        return false;
    }
}
