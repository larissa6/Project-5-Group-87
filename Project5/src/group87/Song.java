package group87;

/**
 * An average song.
 * @author Larissa Schneider (larissa6), Simone Stewart (simone5), Tara Amruthur (taraa2)
 * @version 2015.11.15
 */

public class Song 
{
    private String artistName;
    private String songTitle;
    private String genre;
    private String year;
    
    /**
     * Creates a new song.
     * @param artistName The artist's name.
     * @param songTitle The title of the song.
     * @param genre The song's genre.
     * @param year The year the song was written.
     */
    public Song(String artistName, String songTitle, String genre, String year)
    {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.genre = genre;
        this.year = year;
    }
    
    /**
     * Gets the artist's name.
     * @return The name.
     */
    public String getArtistName()
    {
        return artistName;
    }
    
    /**
     * Gets the song's title.
     * @return The title.
     */
    public String getSongTitle()
    {
        return songTitle;
    }
    
    /**
     * Gets the song's genre.
     * @return The genre.
     */
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * Get's the song's year.
     * @return The year.
     */
    public String getYear()
    {
        return year;
    }
}
