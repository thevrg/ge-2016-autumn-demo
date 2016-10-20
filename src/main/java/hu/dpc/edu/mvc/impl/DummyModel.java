package hu.dpc.edu.mvc.impl;

import hu.dpc.edu.mvc.Dummy;
import hu.dpc.edu.mvc.InMemory;
import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import hu.dpc.edu.mvc.model.MyModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrg on 17/10/16.
 */
@Component
@Dummy
public class DummyModel implements MyModel {

    public DummyModel() {
    }

    public String getMessage() {
        return "Dummy message";
    }

    public void setMessage(String message) {
    }

    public void addMessageChangeListener(MessageChangedListener view) {
    }

    public void removeMessageChangeListener(MessageChangedListener view) {
    }


}
