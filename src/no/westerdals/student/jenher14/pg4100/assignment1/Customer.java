package no.westerdals.student.jenher14.pg4100.assignment1;

/**
 * Created by Herman on 25.01.2016.
 */
public class Customer extends Person implements Runnable
{
    private Rental rental;

    public Customer(String name, Rental rental)
    {
        super(name);
        this.rental = rental;
    }

    @Override
    public void run ()
    {
        try
        {
            while (true)
            {

                Thread.sleep((int) (Math.random() * 9000) + 1000);
                rental.rent(this);
                Thread.sleep((int) (Math.random() * 2000) + 1000);
                rental.returnRentalCar(this);
            }
        }
        catch (InterruptedException e) {}
    }

    public Rental getRental()
    {
        return rental;
    }

    public void setRental(Rental rental)
    {
        this.rental = rental;
    }

    public String toString ()
    {
        return "Customer" + super.toString();
    }

    public boolean equals (Object other)
    {
        if (!(other instanceof Customer))
            return false;

        if (other == this)
            return true;

        Customer c = (Customer) other;
        if (c.getName().equals(getName()))
        {
            if (c.getRental() != null)
                return c.getRental().equals(getRental());

            if (getRental() == null)
                return true;
        }
        return false;
    }
}
