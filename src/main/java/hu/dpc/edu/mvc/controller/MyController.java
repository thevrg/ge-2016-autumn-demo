package hu.dpc.edu.mvc.controller;

import hu.dpc.edu.mvc.view.MyView;

/**
 * Created by vrg on 17/10/16.
 */
public interface MyController {
    public void onSave(String message);
    public MyView onCreateView();
}
