package hu.dpc.edu.mvc;

import hu.dpc.edu.mvc.controller.MyController;
import hu.dpc.edu.mvc.impl.DefaultController;
import hu.dpc.edu.mvc.impl.InMemoryModel;
import hu.dpc.edu.mvc.impl.SwingView;
import hu.dpc.edu.mvc.model.MyModel;
import hu.dpc.edu.mvc.view.MyView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

/**
 * Created by vrg on 17/10/16.
 */

@Configuration
@ComponentScan(basePackages = "hu.dpc.edu.mvc.impl")
public class AutowiredSpringConfig {

    @Dummy
    @Bean
    public MyController dummyController() {
        return new MyController() {
            @Override
            public void onSave(String message) {
                System.out.println("Dummy save....");
            }
        };
    }

}
