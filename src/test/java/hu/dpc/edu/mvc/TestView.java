package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MessageChangedEvent;
import hu.dpc.edu.mvc.model.MessageChangedListener;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;

/**
 * Created by vrg on 19/10/16.
 */
public class TestView implements MyView, MessageChangedListener{

    private MyModel model;
    private MyController controller;

    public TestView(MyModel model, MyController controller) {
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void handleMessageChangedEvent(MessageChangedEvent event) {
        System.out.println("Fake implementation...");
    }

    @Override
    public void setVisible() {
        System.out.println("Fake setVisible impl...");
    }
}
