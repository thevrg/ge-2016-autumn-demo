package hu.dpc.edu;

import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import hu.dpc.edu.mvc.model.MyModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrg on 17/10/16.
 */
public class InMemoryModel implements MyModel, BeanNameAware, ApplicationContextAware {

    public InMemoryModel() {
    }

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

    @Override
    public void setBeanName(String s) {
        System.out.println("I'm a bean, my name is " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }

}
