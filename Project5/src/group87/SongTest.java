package group87;
import student.TestCase;
/**
 * Tests the song class.
 * @author Larissa Schneider (larissa6), Simone Stewart (simone5), Tara Amruthur (taraa2)
 * @version 2015.11.13
 *
 */
public class SongTest extends TestCase
{
    private String artistName;
    private String songTitle;
    private String genre;
    private String year; 
    private Song song;
    
    /**
     * Sets up.
     */
    public void setUp()
    {
        artistName = "Fall Out Boy";
        songTitle = "Uma Thurman";
        genre = "rock";
        year = "2015";
        song = new Song(artistName, songTitle,
                genre, year);
    }
    
    /**
     * Tests the getArtistName method.
     */
    public void testGetArtistName()
    {
        assertTrue(artistName.equals(song.
                getArtistName()));
    }
    
    /**
     * Tests the getSongTitle method.
     */
    public void testGetSongTitle()
    {
        assertTrue(songTitle.equals(song.
                getSongTitle()));
    }
    
    /**
     * Tests the getGenre method.
     */
    public void testGetGenre()
    {
        assertTrue(genre.equals(song.getGenre()));
    }
    
    /**
     * Tests the getYear method.
     */
    public void testGetYear()
    {
        assertTrue(year.equals(song.getYear()));
    }
}
