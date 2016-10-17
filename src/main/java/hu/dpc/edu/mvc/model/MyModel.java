package hu.dpc.edu.mvc.model;

/**
 * Created by vrg on 17/10/16.
 */
public interface MyModel {

    String getMessage();

    void setMessage(String message);

    void addMessageChangeListener(MessageChangedListener view);

    void removeMessageChangeListener(MessageChangedListener view);

}
