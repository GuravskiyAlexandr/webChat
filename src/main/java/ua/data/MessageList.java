package ua.data;/*
 * Created by Alexsandr        13.05.2018
 */

import ua.entity.Message;

import java.util.LinkedList;
import java.util.List;

public class MessageList {
    private static final MessageList classMsgList = new MessageList();
    private final List<Message> list = new LinkedList<Message>();

    public static MessageList getClassMsgList() {
        return classMsgList;
    }

    public List<Message> getList() {
        return list;
    }


}
