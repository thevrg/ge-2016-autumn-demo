package hu.dpc.edu.mvc.impl;

import hu.dpc.edu.mvc.Default;
import hu.dpc.edu.mvc.InMemory;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by vrg on 17/10/16.
 */
@Controller
@Default
public class DefaultController implements MyController {

    private MyModel model;

    private ViewFactory viewFactory;

    public DefaultController() {
    }

    @Autowired
    public DefaultController(@InMemory MyModel model, ViewFactory viewFactory) {
        if (model == null) {
            throw new IllegalArgumentException("Model is required");
        }
        this.viewFactory = viewFactory;
        this.model = model;
    }

    public void setMyModel(MyModel model) {
        this.model = model;
    }

    public void onSave(String message) {
        model.setMessage(message);
    }

    @Override
    public MyView onCreateView() {
        MyView view = viewFactory.createView();
        view.setVisible();
        return view;
    }
}
