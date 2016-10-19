package hu.dpc.edu.mvc;

import hu.dpc.edu.InMemoryModel;
import hu.dpc.edu.SwingView;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by vrg on 19/10/16.
 */
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BetterSpringTest {

    @Autowired
    private MyModel model;

    @Autowired
    private MyView view;

    @Autowired
    private MyController controller;

    @Test
    public void testXMLConfig() {

        //Then
        assertThat("model should be a InMemoryModel", model, instanceOf(InMemoryModel.class));
        assertThat("view should be a SwingView", view, instanceOf(TestView.class));
        assertThat("controller should be a DefaultController", controller, instanceOf(DefaultController.class));

    }
}
