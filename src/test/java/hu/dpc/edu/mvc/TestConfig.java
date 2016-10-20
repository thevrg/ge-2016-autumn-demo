package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.impl.InMemoryModel;
import hu.dpc.edu.LoggerAspect;
import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.impl.DefaultController;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
