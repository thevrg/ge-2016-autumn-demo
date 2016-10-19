package hu.dpc.edu.unittest;

import java.util.Date;

/**
 * Created by vrg on 18/10/16.
 */
public class DateValidator {
    public boolean isInPast(Date date) {
        return date.before(getCurrentTime());
    }

    Date getCurrentTime() {
        return new Date();
    }

    public boolean isInFuture(Date date) {
        return date.after(getCurrentTime());
    }
}
