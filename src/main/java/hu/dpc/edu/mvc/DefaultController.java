package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;

/**
 * Created by vrg on 17/10/16.
 */
public class DefaultController implements MyController {

    private MyModel model;

    public DefaultController(MyModel model) {
        this.model = model;
    }

    public void setModel(MyModel model) {
        this.model = model;
    }

    public void onSave(String message) {
        model.setMessage(message);
    }
}
