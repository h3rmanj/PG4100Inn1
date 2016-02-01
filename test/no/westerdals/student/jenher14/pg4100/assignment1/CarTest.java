package no.westerdals.student.jenher14.pg4100.assignment1;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Created by Herman on 29.01.2016.
 */
public class CarTest
{
    private static final String REGNR = "RR11000";
    private static final String NEWREGNR = "BB81100";

    Car car;

    @Before
    public void setUp () throws Exception
    {
        car = new Car(REGNR);
    }

    @Test
    public void testGetRegNummer () throws Exception
    {
        assertEquals(REGNR, car.getRegNumber());
    }

    @Test
    public void testSetRegNummer () throws Exception
    {
        assertEquals(REGNR, car.getRegNumber());
        car.setRegNumber(NEWREGNR);
        assertEquals(NEWREGNR, car.getRegNumber());
    }

    @Test
    public void testToString () throws Exception
    {
        assertEquals("Registration Number: " + REGNR, car.toString());
    }

    @Test
    public void testEquals () throws Exception
    {
        assertTrue(car.equals(car));
        assertTrue(car.equals(new Car(REGNR)));
        assertFalse(car.equals(new Car(NEWREGNR)));
        assertFalse(car.equals(REGNR));
    }
}
