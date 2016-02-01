/**
 * Herman Jensen
 * PG4100
 * Innlevering 1
 */

package no.westerdals.student.jenher14.pg4100.assignment1;

import org.junit.*;
import static org.junit.Assert.*;

public class CustomerTest
{
    private static final String NAME = "Gunnar";

    Customer customer;

    @Before
    public void setUp () throws Exception
    {
        customer = new Customer(NAME, null);
    }

    @Test
    public void testGetRental () throws Exception
    {
        assertNull(customer.getRental());
    }

    @Test
    public void testSetRental () throws Exception
    {
        assertNull(customer.getRental());
        customer.setRental(new Rental());
        assertNotNull(customer.getRental());
    }

    @Test
    public void testToString () throws Exception
    {
        assertEquals("CustomerName: " + NAME, customer.toString());
    }

    @Test
    public void testEquals () throws Exception
    {
        assertTrue(customer.equals(customer));
        assertTrue(customer.equals(new Customer(NAME, null)));
        assertFalse(customer.equals(new Customer(NAME, new Rental())));
        assertFalse(customer.equals(NAME));
    }
}
