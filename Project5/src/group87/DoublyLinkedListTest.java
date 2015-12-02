package group87;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private Iterator<Person> iter;

    /**
     * sets up the tests before each run
     */
    public void setUp() {
        list = new DoublyLinkedList<String>();
        iter = list.iterator();
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

        assertEquals("Tara", list.get(2));
    }

    /**
     * tests the get method for an index that is out of bounds
     */
    public void testGetOut() {
        list.add("VT");
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

    /**
     * tests the addNodeAtIndex method for an index that is out of bounds
     */
    public void testAddNodeAtIndexOut() {
        Exception thrown = null;
        try {
            list.addNodeAtIndex("hello", -3);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        Exception thrown2 = null;
        try {
            list.addNodeAtIndex("hello", 5);
        }
        catch (Exception e) {
            thrown2 = e;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IndexOutOfBoundsException);
    }

    /**
     * tests the addNodeAtIndex method for each end of the list
     */
    public void testAddNodeAtIndexEnds() {
        list.add("hello");
        list.add("world");

        list.addNodeAtIndex("Simone", 0);
        list.addNodeAtIndex("Larissa", 3);
        assertEquals("Simone", list.get(0));
        assertEquals("Larissa", list.get(3));
    }

    /**
     * tests the addNodeAtIndex method for the middle of the list
     */
    public void testAddNodeAtIndexMiddle() {
        list.add("Simone");
        list.add("Larissa");
        list.add("Tara");
        list.addNodeAtIndex("hello", 2);
        assertEquals("hello", list.get(2));
        assertEquals("Tara", list.get(3));
    }

    /**
     * tests the remove method for when the index is out of bounds
     */
    public void testRemoveOut() {
        list.add("hello");
        list.add("world");
        Exception thrown = null;
        try {
            list.remove(-1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        Exception thrown2 = null;
        try {
            list.remove(2);
        }
        catch (Exception e) {
            thrown2 = e;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IndexOutOfBoundsException);
    }

    /**
     * tests the remove method for a valid remove index
     */
    public void testRemove() {
        list.add("hello");
        list.add("world");
        assertEquals("world", list.remove(1));
    }


    public void testInsertionSort()
    {
        DoublyLinkedList<Song> answerKey = new DoublyLinkedList<Song>();
        answerKey.add(new Song("Elvis Costello",
                "Watching the Detectives", "punk",
                "1977"));
        answerKey.add(new Song("Fall Out Boy",
                "Uma Thurman", "rock", "2015"));
        answerKey.add(new Song("Diana Ross",
                "Upside Down", "disco", "1980"));
        double[] answers = new double[6];
        for (int count = 0; count < answers.length; count++)
        {
            answers[count] = 50;
        }
        answers[1] = 25;
        answers[5] = 30;
        answers = answerKey.insertionSort("Song Title", answers);
        assertTrue(answerKey.get(0).getSongTitle().equals("Uma Thurman"));
        answerKey.insertionSort("Genre", answers);
        assertTrue(answerKey.get(0).getGenre().equals("disco"));
    }

    /**
     * Tests iterator.
     */
    public void testIterator()
    {
        DoublyLinkedList<Person> emptyList = new DoublyLinkedList<Person>();
        Iterator<Person> emptyIter = emptyList.iterator();
        list.add("Hello");
        assertEquals(true, iter.hasNext());
        assertEquals(false, emptyIter.hasNext());
        assertTrue(list.get(0).equals(iter.next()));
        Exception exception = null;
        try {
            emptyIter.next();
        }
        catch (NoSuchElementException n)
        {
            exception = n;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);
    }
}
