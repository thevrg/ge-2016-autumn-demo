package hu.dpc.edu.unittest;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by vrg on 18/10/16.
 */
public class DateValidatorTest {

    DateValidator dateValidator;

    @Before
    public void setup() {
        dateValidator = new DateValidator() {
            @Override
            Date getCurrentTime() {
                try {
                    return new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-20");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        };

    }

    @Test
    public void isInFutureShouldTrueForDatesInFuture() throws Exception {
        //Given

        Date dateInPast = new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-21");

        //When
        final boolean respose = dateValidator.isInFuture(dateInPast);

        //Then
        assertTrue(respose);
    }
    @Test
    public void isInFutureShouldReturnFalseForDatesInPast() throws Exception {
        //Given

        Date dateInPast = new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-1");

        //When
        final boolean respose = dateValidator.isInFuture(dateInPast);

        //Then
        assertFalse(respose);
    }

    @Test
    public void isInPastShouldReturnTrueForDatesInPast() throws Exception {
        //Given
        final DateValidator dateValidator = new DateValidator();
        Date dateInPast = new SimpleDateFormat("yyyy-MM-dd").parse("2016-08-01");

        //When
        final boolean respose = dateValidator.isInPast(dateInPast);

        //Then
        assertTrue(respose);

    }
    @Test
    public void isInPastShouldReturnFalseForDatesInFuture() throws Exception {
        //Given
        final DateValidator dateValidator = new DateValidator();
        Date dateInPast = new SimpleDateFormat("yyyy-MM-dd").parse("2017-08-01");

        //When
        final boolean respose = dateValidator.isInPast(dateInPast);

        //Then
        assertFalse(respose);

    }

}