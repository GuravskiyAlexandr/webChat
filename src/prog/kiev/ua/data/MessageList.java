package prog.kiev.ua.data;/*
 * Created by Alexsandr        13.05.2018
 */

import com.google.gson.Gson;
import prog.kiev.ua.entity.Message;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MessageList {
    private static final MessageList msgList = new MessageList();
    private static final int LIMIT = 100;
    private final List<Message> list = new LinkedList<Message>();

    public static MessageList getMsgList() {
        return msgList;
    }

    public List<Message> getList() {
        return list;
    }


}
