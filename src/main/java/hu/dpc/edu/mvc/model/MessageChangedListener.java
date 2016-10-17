package hu.dpc.edu.mvc.model;

/**
 * Created by vrg on 17/10/16.
 */
public interface MessageChangedListener {
    void handleMessageChangedEvent(MessageChangedEvent event);
}
