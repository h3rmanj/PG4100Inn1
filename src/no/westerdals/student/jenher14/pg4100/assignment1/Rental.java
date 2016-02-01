package no.westerdals.student.jenher14.pg4100.assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Herman on 25.01.2016.
 */
public class Rental
{
    private final ReentrantLock LOCK = new ReentrantLock();
    private Condition noFreeCars = LOCK.newCondition();

    private ArrayList<RentalCar> rentalCars;

    public Rental ()
    {
        rentalCars = new ArrayList<>();
        rentalCars.add(new RentalCar("PG41000"));
        rentalCars.add(new RentalCar("BO08135"));
        rentalCars.add(new RentalCar("RK45331"));
        rentalCars.add(new RentalCar("PP50455"));
        rentalCars.add(new RentalCar("TK10101"));
    }

    public List<RentalCar> getRentalCars ()
    {
        return rentalCars;
    }

    public void rent (Customer customer)
    {
        LOCK.lock();
        try
        {
            while (freeRentalCars() < 1)
            {
                System.out.println(customer.getName() + " is waiting for a rental car.\n");
                noFreeCars.await();
            }

            RentalCar rentalCar = getFreeRentalCar();
            rentalCar.rentTo(customer);

            System.out.println(customer.getName() + " is now renting: " + rentalCar.getRegNumber() + "\n" + toString() + "\n");
        }
        catch (InterruptedException e) {}
        finally { LOCK.unlock(); }
    }

    public void returnRentalCar (Customer customer)
    {
        LOCK.lock();
        try
        {
            RentalCar rentalCar = getRentalCar(customer);
            rentalCar.returnRentalCar();
            noFreeCars.signal();
            System.out.println(customer.getName() + " returned: " + rentalCar.getRegNumber() + "\n" + toString() + "\n");
        }
        finally { LOCK.unlock(); }
    }

    private RentalCar getRentalCar (Customer customer)
    {
        for (RentalCar rentalCar: rentalCars)
            if (customer.equals(rentalCar.getCustomer()))
                return rentalCar;

        return null;
    }

    private RentalCar getFreeRentalCar ()
    {
        for (RentalCar rentalCar : rentalCars)
            if (!rentalCar.isRented())
                return rentalCar;

        return null;
    }

    public int freeRentalCars ()
    {
        int i = 0;
        for (RentalCar rentalCar : rentalCars)
            if (!rentalCar.isRented())
                i++;

        return i;
    }

    public String toString()
    {
        String string = "";

        for (RentalCar rentalCar : rentalCars)
        {
            string += rentalCar.getRegNumber() + " - ";
            if (rentalCar.isRented())
                string += "busy\t";
            else
                string += "free\t";
        }

        return string;
    }

    public boolean equals (Object other)
    {
        if (!(other instanceof Rental))
            return false;
        
        if (other == this)
            return true;
        
        Rental r = (Rental) other;
        return r.getRentalCars().equals(getRentalCars());
    }
}
