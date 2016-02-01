package no.westerdals.student.jenher14.pg4100.assignment1;

/**
 * Created by Herman on 31.01.2016.
 */
public class Person
{
    private String name;

    public Person (String name)
    {
        setName(name);
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        if (name == null)
            this.name = "";
        else
            this.name = name;
    }

    public String toString ()
    {
        return "Name: " + getName();
    }

    public boolean equals (Object other)
    {
        if (!(other instanceof Person))
            return false;

        if (other == this)
            return true;

        Person p = (Person) other;
        return p.getName().equals(getName());
    }
}
