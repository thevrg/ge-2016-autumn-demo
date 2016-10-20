package hu.dpc.edu.mvc.impl;

import hu.dpc.edu.mvc.impl.DefaultController;
import hu.dpc.edu.mvc.model.MyModel;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by vrg on 18/10/16.
 */
public class DefaultControllerTest {


    @Test()
    public void constructorShouldThrowAnIllegalArgumentExceptionIfModelIsNull() {
        //When
        try {
            new DefaultController(null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException ex) {
            //Then
            assertEquals("Model is required", ex.getMessage());
        }
    }

    @Test
    public void onSaveShouldCallSetMessageOnModel() {
        //Given
        final MyModel mockedModel = mock(MyModel.class);

        final DefaultController controller = new DefaultController(mockedModel, null);

        final String messageToSave = "Test Message";

        //When
        controller.onSave(messageToSave);

        //Then
        verify(mockedModel).setMessage(messageToSave);

    }
}