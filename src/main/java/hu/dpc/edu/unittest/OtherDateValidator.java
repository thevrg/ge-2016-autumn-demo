package hu.dpc.edu.unittest;

import java.util.Date;

/**
 * Created by vrg on 18/10/16.
 */
public class OtherDateValidator {

    private CurrentTimeSupplier currentTimeSupplier;

    public OtherDateValidator(CurrentTimeSupplier currentTimeSupplier) {
        this.currentTimeSupplier = currentTimeSupplier;
    }

    public OtherDateValidator() {
        this(new DefaultCurrentTimeSupplier());
    }

    public boolean isInPast(Date date) {
        return date.before(currentTimeSupplier.getCurrentTime());
    }

    public boolean isInFuture(Date date) {
        return date.after(currentTimeSupplier.getCurrentTime());
    }
}
