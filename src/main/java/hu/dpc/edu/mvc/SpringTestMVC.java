package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.impl.SwingView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by vrg on 17/10/16.
 */
public class SpringTestMVC {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //final ApplicationContext context = new ClassPathXmlApplicationContext("/application-config.xml");

        final SwingView view1 = context.getBean("view", SwingView.class);
        final SwingView view2 = context.getBean("view", SwingView.class);


        view1.setVisible();
        view2.setVisible();
    }
}
