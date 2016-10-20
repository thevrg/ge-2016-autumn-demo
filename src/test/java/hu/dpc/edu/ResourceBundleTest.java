package hu.dpc.edu;

import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by vrg on 19/10/16.
 */
public class ResourceBundleTest {

    @Test
    public void testProperties() throws IOException {
        //Given
        final Properties properties = new Properties();
        properties.load(ResourceBundleTest.class.getResourceAsStream("/hu/dpc/edu/messages.properties"));

        System.out.println(properties);
        //When
        final String hello = properties.getProperty("hello");
        //Then
        assertNotNull(hello);
    }
    @Test
    public void testResourceBundleHU() throws IOException {
        //Given
        final ResourceBundle bundle = ResourceBundle.getBundle("hu.dpc.edu.messages", new Locale("hu"));
        //When
        final String hello = bundle.getString("hello");
        //Then
        assertNotNull(hello);
        assertEquals("Szia!", hello);
    }

    @Test
    public void testResourceBundleKO() throws IOException {
        //Given
        final ResourceBundle bundle = ResourceBundle.getBundle("hu.dpc.edu.messages", new Locale("ko"));
        //When
        final String hello = bundle.getString("hello");
        //Then
        assertNotNull(hello);
        assertEquals("Szia!", hello);
    }
}
