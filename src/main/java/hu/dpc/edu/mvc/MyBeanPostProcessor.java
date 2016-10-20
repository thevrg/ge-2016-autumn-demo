package hu.dpc.edu.mvc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by vrg on 19/10/16.
 */

public class MyBeanPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + name);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        System.out.println("postProcessAfterInitialization " + name);
        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        final BeanDefinition modelDef = configurableListableBeanFactory.getBeanDefinition("model");
    }
}
