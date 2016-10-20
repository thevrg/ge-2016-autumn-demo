package hu.dpc.edu.mvc;

import hu.dpc.edu.Person;
import org.springframework.beans.factory.FactoryBean;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vrg on 19/10/16.
 */
public class MyPersonFactory implements FactoryBean<Person> {

    private AtomicLong counter = new AtomicLong();

    private String firstName;
    private String lastName;

    public MyPersonFactory(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Person getObject() throws Exception {
        final Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setId(counter.incrementAndGet());
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
