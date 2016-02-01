/**
 * Herman Jensen
 * PG4100
 * Innlevering 1
 */

package no.westerdals.student.jenher14.pg4100.assignment1;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest
{
    private static final String NAME = "Gunnar";
    private static final String NEWNAME = "Rudolf";

    private Person person;

    @Before
    public void setUp () throws Exception
    {
        person = new Person(NAME);
    }

    @Test
    public void testGetName () throws Exception
    {
        assertEquals(NAME, person.getName());
    }

    @Test
    public void testSetName () throws Exception
    {
        assertEquals(NAME, person.getName());
        person.setName(NEWNAME);
        assertEquals(NEWNAME, person.getName());
    }

    @Test
    public void testToString () throws Exception
    {
        assertEquals("Name: " + NAME, person.toString());
    }

    @Test
    public void testEquals () throws Exception
    {
        assertTrue(person.equals(person));
        assertTrue(person.equals(new Person(NAME)));
        assertFalse(person.equals(new Person(NEWNAME)));
        assertFalse(person.equals(NAME));
    }
}