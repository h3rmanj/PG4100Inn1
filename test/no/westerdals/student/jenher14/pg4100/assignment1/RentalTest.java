/**
 * Herman Jensen
 * PG4100
 * Innlevering 1
 */

package no.westerdals.student.jenher14.pg4100.assignment1;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RentalTest
{
    Rental rental;

    @Before
    public void setUp () throws Exception
    {
        rental = new Rental();
    }

    @Test
    public void testGetRentalCars () throws Exception
    {
        List<RentalCar> rentalCars = new ArrayList<>();
        rentalCars.add(new RentalCar("PG41000"));
        rentalCars.add(new RentalCar("BO08135"));
        rentalCars.add(new RentalCar("RK45331"));
        rentalCars.add(new RentalCar("PP50455"));
        rentalCars.add(new RentalCar("TK10101"));

        assertEquals(rentalCars, rental.getRentalCars());
    }

    @Test
    public void testFreeRentalCars () throws Exception
    {
        assertEquals(5, rental.freeRentalCars());
    }

    @Test
    public void testRent () throws Exception
    {
        assertEquals(5, rental.freeRentalCars());
        rental.rent(new Customer(null, null));
        assertEquals(4, rental.freeRentalCars());
    }

    @Test
    public void testReturnRentalCar () throws Exception
    {
        Customer c = new Customer(null, rental);
        rental.rent(c);
        assertEquals(4, rental.freeRentalCars());
        rental.returnRentalCar(c);
        assertEquals(5, rental.freeRentalCars());
    }

    @Test
    public void testToString () throws Exception
    {
        assertEquals("PG41000 - free\tBO08135 - free\tRK45331 - free\tPP50455 - free\tTK10101 - free\t", rental.toString());
        rental.rent(new Customer(null, null));
        assertEquals("PG41000 - busy\tBO08135 - free\tRK45331 - free\tPP50455 - free\tTK10101 - free\t", rental.toString());
    }

    @Test
    public void testEquals () throws Exception
    {
        assertTrue(rental.equals(rental));
        assertTrue(rental.equals(new Rental()));
        assertFalse(rental.equals("Bjørnar"));
    }
}
