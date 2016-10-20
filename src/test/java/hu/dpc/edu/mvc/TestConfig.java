package hu.dpc.edu.mvc;

import hu.dpc.edu.InMemoryModel;
import hu.dpc.edu.LoggerAspect;
import hu.dpc.edu.SwingView;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

/**
 * Created by vrg on 17/10/16.
 */
@EnableAspectJAutoProxy
@Configuration
public class TestConfig {

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }

    @Bean
    public MyModel model() {
        return new InMemoryModel();
    }

    @Bean
    public MyController controller() {
        return new DefaultController(model());
    }

    @Bean
//    @Scope("prototype")
    public MyView view() {
        return new TestView(model(), controller());
    }
}
