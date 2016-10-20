package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.impl.InMemoryModel;
import hu.dpc.edu.LoggerAspect;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.impl.DefaultController;
import hu.dpc.edu.mvc.impl.ViewFactory;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import javax.swing.text.View;

/**
 * Created by vrg on 17/10/16.
 */
@EnableAspectJAutoProxy
@Configuration
public class TestConfig {

    @Bean
    public ViewFactory viewFactory(BeanFactory beanFactory) {
        return new ViewFactory(beanFactory);
    }

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }

    @Bean
    public MyModel model() {
        return new InMemoryModel();
    }

    @Bean
    public MyController controller(MyModel model, ViewFactory viewFactory) {
        return new DefaultController(model, viewFactory);
    }

    @Bean
    @Scope("prototype")
    public MyView view(MyController controller) {
        return new TestView(model(), controller);
    }
}
