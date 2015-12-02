package group87;

import student.TestCase;

/**
 * // -------------------------------------------------------------------------
/**
 *  Tests the methods found in SongList
 *
 *  @author Simone Stewart (simone5), Larissa Schneider (larissa6),
 *  Tara (taraa2)
 *  @version 2015.12.02
 */
public class SongListTest
    extends TestCase
{
    //Fields ------------------------------------------------------------------
    private SongList songs;

    /**
     * sets up the test before each run
     */
    public void setUp() {
        DoublyLinkedList<Song> list = new DoublyLinkedList<Song>();
        list.add(new Song("Elvis Costello",
            "Watching the Detectives", "punk",
            "1977"));
        list.add(new Song("Fall Out Boy",
            "Uma Thurman", "rock", "2015"));
        list.add(new Song("Diana Ross",
            "Upside Down", "disco", "1980"));
        songs = new SongList(list);
    }

    //Tests -------------------------------------------------------------------
    /**
     * tests the sort method
     */
    public void testSort()
    {
        songs.sort("Song Title");
        assertEquals("Upside Down", songs.toList().get(1).getSongTitle());
    }
}
