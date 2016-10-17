package hu.dpc.edu;

import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import hu.dpc.edu.mvc.model.MyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrg on 17/10/16.
 */
public class InMemoryModel implements MyModel {
    private String message;
    private List<MessageChangedListener> messageChangedListeners = new ArrayList<MessageChangedListener>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {

        MessageChangedEvent event = new MessageChangedEvent(this, this.message, message);
        this.message = message;

        for (MessageChangedListener listener: messageChangedListeners) {
            listener.handleMessageChangedEvent(event);
        }

    }

    public void addMessageChangeListener(MessageChangedListener view) {
        messageChangedListeners.add(view);

    }

    public void removeMessageChangeListener(MessageChangedListener view) {
        messageChangedListeners.remove(view);
    }
}
