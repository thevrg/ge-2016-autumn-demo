package hu.dpc.edu;

import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

/**
 * Created by vrg on 18/10/16.
 */
public class InMemoryModelTestJunit5 {

    @Test
    @DisplayName("getMessage() should return the last value set by setMessage()")
    public void getMessageShouldReturnTheLastValueSetBySetMessage() {
        //Given
        final InMemoryModel model = new InMemoryModel();
        //When
        model.setMessage("hello");
        //Then
        assertEquals("hello", model.getMessage());

    }

    private MessageChangedEvent receivedEvent;

    @Test
    @DisplayName("setMessage() should notify the registered MessageChangedListeners about the change")
    public void setMessageShouldNotifyTheRegisteredMessageChangedListenersAboutTheChange() {
        //Given
        final InMemoryModel model = new InMemoryModel();
        model.setMessage("initial value");

        model.addMessageChangeListener(new MessageChangedListener() {
            @Override
            public void handleMessageChangedEvent(MessageChangedEvent event) {
                receivedEvent = event;
            }
        });

        //When
        model.setMessage("test value");

        //Then
        assertNotNull(receivedEvent);
        assertEquals("initial value", receivedEvent.getOldMessage());
        assertEquals("test value", receivedEvent.getNewMessage());
        assertSame(model, receivedEvent.getSource());
    }
}