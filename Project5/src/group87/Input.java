package group87;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Reads the files.
 * @author Tara Amruthur (taraa2), Simone Stewart (simone5),
 * Larissa Schneider (larissa6)
 * @version 11.14.2015
 *
 */
public class Input 
{
    /**
     * Calls the methods to read the file
     * @param theFile the file to be read.
     * @throws IOException
     */
    public static void main(String theFile) throws IOException
    {
        readFile("MusicSurveyData.csv");
        readSongFile("SongList.csv");
        
    }
    
    /**
     * Creates a peoplelist of the people in the file.
     * @param theFile the file to be read.
     * @return peoplelist of people in file.
     * @throws IOException
     */
    public static PeopleList readFile(String theFile) throws IOException
    {
        File aFile = new File(theFile);
        PeopleList group = new PeopleList();
        group.setAnswerKey(readSongFile("SongList.csv").toList());
        Scanner scanner = new Scanner(aFile);
        scanner.nextLine();
        for (int i = 0; i < numOfLines(aFile) - 2; i++)
        {
            group.addPerson(makeAPerson(scanner));
        }
        return group;
        
    }
    
    /**
     * Counts the number of lines in the file.
     * @param file the file to be read.
     * @return number of lines.
     * @throws FileNotFoundException
     */
    private static int numOfLines(File file) throws FileNotFoundException
    {
        int index = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            index++;
            scanner.nextLine();
        }
        scanner.close();
        return index;
    }
    
    /**
     * Makes a person based on a line of the file.
     * @param line the line to make a person from
     * @return Person
     */
    private static Person makeAPerson(Scanner line)
    {
        String theLine = line.nextLine();
        theLine = theLine.replace(",", ", ");
        String[] info = theLine.split(Pattern.quote(","));
        String major = info[2];
        String region = info[3];
        String hobby = info[4];
        DoublyLinkedList<String> answers = new DoublyLinkedList<String>();
        for (int i = 5; i < info.length; i++)
        {
            answers.add(info[i]);
        }
        Person thePerson = new Person(hobby, major, region, answers);
        return thePerson;
    }
    
    /**
     * Creates a list of songs
     * @param songFile the file of songs
     * @return doubly linked list of songs
     * @throws IOException
     */
    public static SongList readSongFile(String songFile) throws IOException
    {
        DoublyLinkedList<Song> songList = new DoublyLinkedList<Song>();
        File songFiles = new File(songFile);
        Scanner scanner = new Scanner(songFiles);
        scanner.nextLine();
        for (int i = 0; i < numOfLines(songFiles) - 1; i++)
        {
            songList.add(createSong(scanner));
        }
        scanner.close();
        SongList actualSongList = new SongList(songList);
        return actualSongList;
    }
    
    /**
     * Creates a song based on the line
     * @param theScanner
     * @return a song object
     */
    private static Song createSong(Scanner theScanner)
    {
        String line = theScanner.nextLine();
        String[] array = line.split(",");
        String title = array[0];
        String artist = array[1];
        String year = array[2];
        String genre = array[3];
        Song theSong = new Song(title, artist, genre, year);
        return theSong;
    }
    
    
}