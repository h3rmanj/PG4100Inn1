/**
 * Herman Jensen
 * PG4100
 * Innlevering 1
 */

package no.westerdals.student.jenher14.pg4100.assignment1;

import org.junit.*;
import static org.junit.Assert.*;

public class RentalCarTest
{
    private static final String REGNR = "RR11000";
    RentalCar rentalCar;

    @Before
    public void setUp () throws Exception
    {
        rentalCar = new RentalCar(REGNR);
    }

    @Test
    public void testGetCustomer () throws Exception
    {
        assertNull(rentalCar.getCustomer());
    }

    @Test
    public void testRentTo () throws Exception
    {
        assertNull(rentalCar.getCustomer());
        rentalCar.rentTo(new Customer(null, null));
        assertNotNull(rentalCar.getCustomer());
    }

    @Test
    public void testReturnRentalCar () throws Exception
    {
        rentalCar.rentTo(new Customer(null, null));
        assertNotNull(rentalCar.getCustomer());
        rentalCar.returnRentalCar();
        assertNull(rentalCar.getCustomer());
    }

    @Test
    public void testIsRented () throws Exception
    {
        assertFalse(rentalCar.isRented());
    }

    @Test
    public void testToString () throws Exception
    {
        assertEquals("Registration Number: " + REGNR + ", Currently not rented", rentalCar.toString());
        String name = "Rudolf";
        rentalCar.rentTo(new Customer(name, null));
        assertEquals("Registration Number: " + REGNR + ", Rented by: " + name, rentalCar.toString());
    }

    @Test
    public void testEquals () throws Exception
    {
        assertTrue(rentalCar.equals(rentalCar));
        assertTrue(rentalCar.equals(new RentalCar(REGNR)));
        assertFalse(rentalCar.equals(new RentalCar(null)));
        assertFalse(rentalCar.equals(REGNR));
    }
}
