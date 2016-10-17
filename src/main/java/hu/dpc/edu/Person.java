package hu.dpc.edu;

/**
 * Created by vrg on 17/10/16.
 */
public class Person {

    private String firstName;
    private String lastName;
    private Long azonosito;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return azonosito;
    }

    public void setId(Long id) {
        this.azonosito = id;
    }

    public boolean isActive() {
        return true;
    }
}
