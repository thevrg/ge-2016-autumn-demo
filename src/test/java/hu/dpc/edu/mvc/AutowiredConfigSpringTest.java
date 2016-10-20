package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.impl.DefaultController;
import hu.dpc.edu.mvc.impl.DummyModel;
import hu.dpc.edu.mvc.impl.InMemoryModel;
import hu.dpc.edu.mvc.impl.SwingView;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by vrg on 19/10/16.
 */
@ContextConfiguration(classes = AutowiredSpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AutowiredConfigSpringTest {

    @Autowired
    @Dummy
    private MyModel dummyModel;

    @Autowired
    @InMemory
    private MyModel inMemoryModel;

    @Autowired
    private List<MyModel>modelList;

    @Autowired
    private MyView view;

    @Autowired
    @Default
    private MyController controller;

    @Autowired
    @Dummy
    private MyController dummyController;

    @Test
    public void testAutowiredConfig() {

        //Then
        assertThat("dummyModel should be a DummyModel", dummyModel, instanceOf(DummyModel.class));
        assertThat("dummyModel should be a InMemoryModel", inMemoryModel, instanceOf(InMemoryModel.class));
        assertThat("view should be a SwingView", view, instanceOf(SwingView.class));
        assertThat("controller should be a DefaultController", controller, instanceOf(DefaultController.class));
        assertThat(modelList.size(), is(2));
        assertThat(modelList, hasItems(instanceOf(DummyModel.class),instanceOf(InMemoryModel.class)));

    }
}
