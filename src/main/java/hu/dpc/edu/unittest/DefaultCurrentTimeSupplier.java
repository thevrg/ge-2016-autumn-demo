package hu.dpc.edu.unittest;

import java.util.Date;

/**
 * Created by vrg on 18/10/16.
 */
public class DefaultCurrentTimeSupplier implements CurrentTimeSupplier {
    @Override
    public Date getCurrentTime() {
        return new Date();
    }
}
