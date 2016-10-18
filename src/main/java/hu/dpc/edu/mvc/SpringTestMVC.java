package hu.dpc.edu.mvc;

import hu.dpc.edu.SwingView;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vrg on 17/10/16.
 */
public class SpringTestMVC {
    public static void main(String[] args) {
        //final ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        final ApplicationContext context = new ClassPathXmlApplicationContext("/application-config.xml");
        final MyModel model = context.getBean(MyModel.class);

        final SwingView view = context.getBean("view", SwingView.class);


        System.out.println(model.getClass());
        System.out.println(view.getClass());

        model.addMessageChangeListener(view);

        view.setVisible();
    }
}
