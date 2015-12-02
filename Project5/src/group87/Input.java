package group87;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Input 
{
    public static void main(String theFile) throws IOException
    {
        new GUIDisplayWindow();
        readFile("MusicSurveyData.csv");
        readSongFile("SongList.csv");
        
    }
    
    public static PeopleList readFile(String theFile) throws IOException
    {
        PeopleList group = new PeopleList();
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(theFile));
        DoublyLinkedList<String> answers = new DoublyLinkedList<String>();
        BufferedReader br = null;
        String splitBy = ", ";
        while (file.hasNext())
        {
            br = new BufferedReader(new FileReader(theFile));
            String line = br.readLine();
            String[] info = line.split(splitBy);
            for (int i = 4; i < info.length; i++)
            {
                answers.add(info[i]);
            }
            Person thePerson = new Person(info[0], info[1], info[2], info[3], answers);
            group.addPerson(thePerson);
        }
        return group;
        
    }
    
    public static DoublyLinkedList readSongFile(String songFile) throws IOException
    {
        DoublyLinkedList<Song> songList = new DoublyLinkedList<Song>();
        BufferedReader reader = null;
        Scanner file = new Scanner(new File(songFile));
        String splitBy = ", ";
        while (file.hasNext())
        {
            reader = new BufferedReader(new FileReader(songFile));
            String line = reader.readLine();
            String[] songDetails = line.split(splitBy);
            songList.add(new Song(songDetails[0], songDetails[1], songDetails[2], songDetails[3]));
        }
        return songList;
    }
}

