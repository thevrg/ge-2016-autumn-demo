package hu.dpc.edu;

import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by vrg on 18/10/16.
 */
public class InMemoryModelTest {

    //Given
    InMemoryModel model;

    @Before
    public void setup() {
         model = new InMemoryModel();
    }


    @Test
    public void getMessageShouldReturnTheLastValueSetBySetMessage() {
        //When
        model.setMessage("hello");
        //Then
        assertEquals("hello", model.getMessage());

    }

    private MessageChangedEvent receivedEvent;

    @Test
    public void setMessageShouldNotifyTheRegisteredMessageChangedListenersAboutTheChange() {
        //Given
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