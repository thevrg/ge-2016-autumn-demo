package hu.dpc.edu.mvc.impl;

import hu.dpc.edu.mvc.view.MyView;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vrg on 20/10/16.
 */
@Component
public class ViewFactory {

    private BeanFactory beanFactory;

    @Autowired
    public ViewFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public MyView createView() {
        return beanFactory.getBean(MyView.class);
    }
}
