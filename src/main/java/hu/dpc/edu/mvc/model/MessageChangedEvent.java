package hu.dpc.edu.mvc.model;

import java.util.EventObject;

/**
 * Created by vrg on 17/10/16.
 */
public class MessageChangedEvent extends EventObject {

    private final String oldMessage;
    private final String newMessage;

    public MessageChangedEvent(Object source, String oldMessage, String newMessage) {
        super(source);
        this.oldMessage = oldMessage;
        this.newMessage = newMessage;
    }

    public String getNewMessage() {
        return newMessage;
    }

    public String getOldMessage() {
        return oldMessage;
    }
}
