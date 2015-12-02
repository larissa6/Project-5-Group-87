package group87;


/**
 * // -------------------------------------------------------------------------
/**
 *  Makes a DoublyLinkedList of Songs and allows sorting of them
 *
 *  @author Simone Stewart (simone5), Larissa Schneider (larissa6),
 *  Tara (taraa2)
 *  @version 2015.12.02
 */
public class SongList extends DoublyLinkedList<Song>
{
    //Fields ------------------------------------------------------------------

    //Constructor -------------------------------------------------------------
    /**
     * Creates a new this object.
     */
    public SongList() {
        super();
    }

    //Methods -----------------------------------------------------------------
    /**
     * sorts the list by song title, artist, or genre
     * @param param the song attribute to be sorted by
     */
    public void sort(String param) {
        DoublyLinkedList<Song> ans = new DoublyLinkedList<Song>();
        if (param.equals("Song Title")) {
            while (size() != 0) {
                String title = get(0).getSongTitle();
                int index = 0;
                for (int i = 0; i < size(); i++) {
                    if (get(i).getSongTitle().compareTo(title) < 0)
                    {
                        title = get(i).getSongTitle();
                        index = i;
                    }
                }
                ans.add(remove(index));
            }
        }
        else if (param.equals("Artist Name")) {
            while (size() != 0) {
                String artist = get(0).getArtistName();
                int index = 0;
                for (int i = 0; i < this.size(); i++) {
                    if (get(i).getArtistName().compareTo(artist) < 0)
                    {
                        artist = this.get(i).getArtistName();
                        index = i;
                    }
                }
                ans.add(remove(index));
            }
        }
        else if (param.equals("Genre")) {
            while (size() != 0) {
                String genre = this.get(0).getGenre();
                int index = 0;
                for (int i = 0; i < this.size(); i++) {
                    if (get(i).getGenre().compareTo(genre) < 0)
                    {
                        genre = get(i).getGenre();
                        index = i;
                    }
                }
                add(this.remove(index));
            }
        }
        else {
            throw new IllegalArgumentException("Please choose Song Title, "
                + "Artist Name, or Genre");
        }
    }
}
