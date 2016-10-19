package hu.dpc.edu.mvc;

import org.junit.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by vrg on 18/10/16.
 */
public class FixtureDemo {

    private static final AtomicLong counter = new AtomicLong();
    private final long id;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");

    }
    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass, counter: " + counter);
    }

    public FixtureDemo() {
        id = counter.incrementAndGet();
    }

    @Before
    public void before() {
        System.out.println(id + ": before");
    }

    @After
    public void after() {
        System.out.println(id + ": after");
    }

    @Test
    public void testA() {
        System.out.println(id +  ": testA");

    }
    @Test
    public void testB() {
        System.out.println(id +  ": testB");
    }
}
