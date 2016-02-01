/**
 * Herman Jensen
 * PG4100
 * Innlevering 1
 */

package no.westerdals.student.jenher14.pg4100.assignment1;

public class Car
{
    private String regNumber;

    public Car (String regNumber)
    {
        setRegNumber(regNumber);
    }

    public String getRegNumber ()
    {
        return regNumber;
    }

    public void setRegNumber (String regNumber)
    {
        if (regNumber == null)
            this.regNumber = "";
        else
            this.regNumber = regNumber;
    }

    public String toString ()
    {
        return "Registration Number: " + getRegNumber();
    }

    public boolean equals (Object other)
    {
        if (!(other instanceof Car))
            return false;

        if (other == this)
            return true;

        Car c = (Car) other;
        return c.getRegNumber().equals(getRegNumber());
    }
}
