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
public class SongList
{
    //Fields ------------------------------------------------------------------
    private DoublyLinkedList<Song> songList;

    //Constructor -------------------------------------------------------------
    /**
     * Creates a new this object.
     * @param list a doubly linked list of songs to sort
     */
    public SongList(DoublyLinkedList<Song> list) {
        songList = list;
    }

    //Methods -----------------------------------------------------------------
    /**
     * @return the list as a DoublyLinkedList
     */
    public DoublyLinkedList<Song> toList() {
        return songList;
    }

    /**
     * sorts the list by song title, artist, or genre
     * @param param the song attribute to be sorted by
     */
    public void sort(String param) {
        DoublyLinkedList<Song> ans = new DoublyLinkedList<Song>();
        if (param.equals("Song Title")) {
            while (songList.size() != 0) {
                String title = songList.get(0).getSongTitle();
                int index = 0;
                for (int i = 0; i < songList.size(); i++) {
                    if (songList.get(i).getSongTitle().compareTo(title) < 0)
                    {
                        title = songList.get(i).getSongTitle();
                        index = i;
                    }
                }
                ans.add(songList.remove(index));
            }
        }
        else if (param.equals("Artist Name")) {
            while (songList.size() != 0) {
                String artist = songList.get(0).getArtistName();
                int index = 0;
                for (int i = 0; i < songList.size(); i++) {
                    if (songList.get(i).getArtistName().compareTo(artist) < 0)
                    {
                        artist = songList.get(i).getArtistName();
                        index = i;
                    }
                }
                ans.add(songList.remove(index));
            }
        }
        else if (param.equals("Genre")) {
            while (songList.size() != 0) {
                String genre = songList.get(0).getGenre();
                int index = 0;
                for (int i = 0; i < songList.size(); i++) {
                    if (songList.get(i).getGenre().compareTo(genre) < 0)
                    {
                        genre = songList.get(i).getGenre();
                        index = i;
                    }
                }
                ans.add(this.songList.remove(index));
            }
        }
        else {
            throw new IllegalArgumentException("Please choose Song Title, "
                + "Artist Name, or Genre");
        }
        songList = ans;
    }
}
