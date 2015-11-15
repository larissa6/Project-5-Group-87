package group87;

import student.TestCase;


/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the methods found in DoublyLinkedList
 *
 *  @author Simone Stewart (simone5), Larissa Schneider (larissa6),
 *  Tara Amruthur (taraa2)
 *  @version 2015.11.15
 */
public class DoublyLinkedListTest
    extends TestCase
{
    //Fields ------------------------------------------------------------------
    private DoublyLinkedList<String> list;

    /**
     * sets up the tests before each run
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
    }

    //Methods -----------------------------------------------------------------
    /**
     * tests the isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add("hello");
        assertFalse(list.isEmpty());
    }

    /**
     * tests the size method
     */
    public void testSize() {
        assertEquals(0, list.size());

        list.add("hello");
        assertEquals(1, list.size());
    }

    /**
     * tests the clear method
     */
    public void testClear() {
        list.add("hello");
        list.add("world");
        list.clear();
        assertTrue(list.isEmpty());
    }

    /**
     * tests the contains method
     * NOTE we are getting a NullPointerException at line 67 here
     */
    public void testContains() {
        list.add("Simone");
        list.add("Larissa");
        list.add("Tara");
        assertTrue(list.contains("Larissa"));
        assertFalse(list.contains("Fred"));
    }

    /**
     * tests the get method
     */
    public void testGet() {
        list.add("Simone");
        list.add("Larissa");
        list.add("Tara");

        assertEquals("Larissa", list.get(2));
    }

    /**
     * tests the get method for an index that is out of bounds
     */
    public void testGetOut() {
        list.add("hello");
        Exception thrown = null;
        try {
            list.get(5);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }
}
