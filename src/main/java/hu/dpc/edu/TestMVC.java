package hu.dpc.edu;

import hu.dpc.edu.mvc.DefaultController;
import hu.dpc.edu.mvc.model.MyModel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by vrg on 17/10/16.
 */
public class TestMVC {
    public static void main(String[] args) {
        final MyModel model = new InMemoryModel();
        final DefaultController controller = new DefaultController(model);
        final SwingView view = new SwingView(model, controller);

        model.addMessageChangeListener(view);

        view.setVisible();

        new Timer().schedule(new TimerTask() {

                    public void run() {
                        model.setMessage("Hello");

                    }
                }
        , 10000L);


    }
}
