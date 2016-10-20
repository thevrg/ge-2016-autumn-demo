package hu.dpc.edu.mvc;

import hu.dpc.edu.LoggerAspect;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by vrg on 19/10/16.
 */
@ContextConfiguration(classes = TestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAspect {

    @Autowired
    private MyModel model;

    @Autowired
    private LoggerAspect loggerAspect;


    @Test
    public void test() {


        System.out.println(model);

        model.setMessage("ize");
        final String message = model.getMessage();
    }
}
