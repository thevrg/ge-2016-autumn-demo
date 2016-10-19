package hu.dpc.edu.mvc;

import hu.dpc.edu.SwingView;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by vrg on 19/10/16.
 */
public class SpringTest {
    @Test
    public void testXMLConfig() {
        //Given
        try (final ClassPathXmlApplicationContext context
                     = new ClassPathXmlApplicationContext("/application-config.xml")) {

            //When
            final Object model = context.getBean("model");
            final Object view = context.getBean("view");
            final Object controller = context.getBean("controller");

            //Then

            assertThat("model should be a MyModel", model, allOf(notNullValue(), instanceOf(MyModel.class)));
            assertThat("view should be a MyView", view, allOf(notNullValue(), instanceOf(MyView.class)));
            assertThat("controller should be a MyController", controller, allOf(notNullValue(), instanceOf(MyController.class)));
        }

    }
}
