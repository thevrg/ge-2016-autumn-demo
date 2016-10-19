package hu.dpc.edu.unittest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vrg on 18/10/16.
 */
public class OtherDateValidatorTest {

    OtherDateValidator dateValidator;
    CurrentTimeSupplier currentTimeSupplier;
    @Before
    public void setup() throws Exception {

        currentTimeSupplier = mock(CurrentTimeSupplier.class);

        when(currentTimeSupplier.getCurrentTime())
                .thenReturn(parseDate("2016-04-01"));



        dateValidator = new OtherDateValidator(currentTimeSupplier);
    }

    private Date parseDate(String source) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(source);
    }

    @Test
    public void isInFutureShouldReturnTrueForDatesInFuture() throws Exception {
        //Given

        Date dateInPast = parseDate("2016-10-21");

        //When
        final boolean respose = dateValidator.isInFuture(dateInPast);

        //Then
        assertTrue(respose);
        verify(currentTimeSupplier).getCurrentTime();
    }
    @Test
    public void isInFutureShouldReturnFalseForDatesInPast() throws Exception {
        //Given

        Date dateInPast = parseDate("2016-01-01");

        //When
        final boolean respose = dateValidator.isInFuture(dateInPast);

        //Then
        assertFalse(respose);
    }

    @Test
    public void isInPastShouldReturnTrueForDatesInPast() throws Exception {
        //Given
        final DateValidator dateValidator = new DateValidator();
        Date dateInPast = parseDate("2016-08-01");

        //When
        final boolean respose = dateValidator.isInPast(dateInPast);

        //Then
        assertTrue(respose);

    }
    @Test
    public void isInPastShouldReturnFalseForDatesInFuture() throws Exception {
        //Given
        final DateValidator dateValidator = new DateValidator();
        Date dateInPast = parseDate("2017-08-01");

        //When
        final boolean respose = dateValidator.isInPast(dateInPast);

        //Then
        assertFalse(respose);

    }

}