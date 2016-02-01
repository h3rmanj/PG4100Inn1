package no.westerdals.student.jenher14.pg4100.assignment1;

/**
 * Created by Herman on 25.01.2016.
 */
public class RentalCar extends Car
{
    private Customer customer;

    public RentalCar(String regNumber)
    {
        super(regNumber);
    }

    public Customer getCustomer ()
    {
        return customer;
    }

    public boolean isRented ()
    {
        return customer != null;
    }

    public void rentTo (Customer customer)
    {
        this.customer = customer;
    }

    public void returnRentalCar ()
    {
        customer = null;
    }

    public String toString ()
    {
        String re = ", Currently not rented";
        if (isRented())
            re = ", Rented by: " + customer.getName();

        return super.toString() + re;
    }

    public boolean equals (Object other)
    {
        if (!(other instanceof RentalCar))
            return false;

        if (other == this)
            return true;

        RentalCar rC = (RentalCar) other;

        if (rC.getRegNumber().equals(getRegNumber()))
        {
            if (rC.getCustomer() != null)
                return rC.getCustomer().equals(getCustomer());

            if (getCustomer() == null)
                return true;
        }
        return false;
    }
}
