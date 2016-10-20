package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vrg on 17/10/16.
 */
public class DefaultController implements MyController {

    private MyModel model;

    public DefaultController() {
    }

    public DefaultController(MyModel model) {
        if (model == null) {
            throw new IllegalArgumentException("Model is required");
        }
        this.model = model;
    }

    public void setMyModel(MyModel model) {
        this.model = model;
    }

    public void onSave(String message) {
        model.setMessage(message);
    }
}
