package group87;

import CS2114.TextShape;
import java.awt.Color;
import java.io.IOException;

import CS2114.Shape;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;

/**
 * // -------------------------------------------------------------------------
/**
 *  Creates a window to display the data and sorts it as indicated by the
 *  buttons
 *
 *  @author Simone Stewart (simone5),
 *  @author Larissa Schneider (larissa6)
 *  @author Tara Amruthur (taraa2)
 *  @version 2015.12.01
 */
public class GUIDisplayWindow
{
    //Fields ------------------------------------------------------------------
    private Window window;
    private static int LEGEND_WIDTH = 130;
    private static int LEGEND_HEIGHT = 127;
    private int legendStartX;
    private int legendStartY;
    private Graph graph1;
    private Graph graph2;
    private Graph graph3;
    private Graph graph4;
    private Graph graph5;
    private Graph graph6;
    private Graph graph7;
    private Graph graph8;
    private Graph graph9;
    private DoublyLinkedList<Graph> graphs;
    private PeopleList myPeople;
    private SongList mySongs;
    private int peopleIndex;
    private int songIndex;
    private Shape coverShape;
    private TextShape start;
    private Legend legend;
    private Button previous;
    private Button next;
    private double[] answers;

    //Constructor--------------------------------------------------------------
    /**
     * creates a new DisplayWindow
     */
    public GUIDisplayWindow() {
        window = new Window("Project 5");
        legendStartX = window.getWidth() - 5;
        legendStartY = window.getHeight() - 250;
        peopleIndex = 0;
        songIndex = 0;
        try {
            myPeople = Input.readFile("MusicSurveyData.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mySongs = Input.readSongFile("SongList.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        answers = new double[myPeople.getPercentageByHobby().length];
        //Adds Buttons to the top of the window
        previous = new Button("<-- Prev");
        previous.onClick(this, "clickedPrevious");
        window.addButton(previous, WindowSide.NORTH);
        Button artist = new Button("Sort by Artist Name");
        previous.disable();
        artist.onClick(this, "clickedArtist");
        window.addButton(artist, WindowSide.NORTH);
        Button song = new Button("Sort by Song Title");
        song.onClick(this, "clickedSong");
        window.addButton(song, WindowSide.NORTH);
        Button year = new Button("Sort by Release Year");
        year.onClick(this, "clickedYear");
        window.addButton(year, WindowSide.NORTH);
        Button genre = new Button("Sort by Genre");
        genre.onClick(this, "clickedGenre");
        window.addButton(genre, WindowSide.NORTH);
        next = new Button("Next -->");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);
        next.disable();
        //Adds Buttons to the bottom of the window
        Button hobby = new Button("Represent Hobby");
        hobby.onClick(this, "clickedHobby");
        window.addButton(hobby, WindowSide.SOUTH);
        Button major = new Button("Represent Major");
        major.onClick(this, "clickedMajor");
        window.addButton(major, WindowSide.SOUTH);
        Button region = new Button("Represent Region");
        region.onClick(this, "clickedRegion");
        window.addButton(region, WindowSide.SOUTH);
        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
        coverShape = new Shape(0,0,window.getWidth(),window.getHeight(),Color.WHITE);
        start = new TextShape(0,0, "Please select how to represent songs.");
        start.moveTo(window.getWidth()/2 - start.getWidth()/2, window.getHeight()/2 - start.getHeight()/2);

        //creates the initial legend
        legend = new Legend(window, legendStartX, legendStartY);
        graph1 = new Graph(20, 20, "", "", window);
        graph2 = new Graph(220, 20, "", "", window);
        graph3 = new Graph(420, 20, "", "", window);
        graph4 = new Graph(20, 120, "", "", window);
        graph5 = new Graph(220, 120, "", "", window);
        graph6 = new Graph(420, 120, "", "", window);
        graph7 = new Graph(20, 220, "", "", window);
        graph8 = new Graph(220, 220, "", "", window);
        graph9 = new Graph(420, 220, "", "", window);
        window.addShape(coverShape);
        window.moveToFront(coverShape);
        window.addShape(start);
        window.moveToFront(start);
        graphs = new DoublyLinkedList<Graph>();
        graphs.add(graph1);
        graphs.add(graph2);
        graphs.add(graph3);
        graphs.add(graph4);
        graphs.add(graph5);
        graphs.add(graph6);
        graphs.add(graph7);
        graphs.add(graph8);
        graphs.add(graph9);
    }

    //Methods -----------------------------------------------------------------
    /**
     * supports the previous button
     * @param button the previous button
     */
    public void clickedPrevious(Button button) {
        songIndex = songIndex - 9;
        display();
        if (songIndex <= 0)
        {
            previous.disable();
            previous.repaint();
        }
        //TODO disable if at the first page
    }

    /**
     * supports the next button
     * @param button the next button
     */
    public void clickedNext(Button button) {
        previous.enable();
        songIndex = songIndex + 9;
        if (songIndex > mySongs.toList().size() - 9)
        {
            next.disable();
        }
        next.repaint();
        display();
    }

    /**
     * supports the artist button
     * @param button the artist button
     */
    public void clickedArtist(Button button) {
        mySongs.sort("Song Title");
        songIndex = 0;
        display();
    }

    /**
     * supports the song button
     * @param button the song button
     */
    public void clickedSong(Button button) {
        mySongs.sort("Artist Name");
        songIndex = 0;
        display();
    }

    /**
     * supports the year button
     * @param button the year button
     */
    public void clickedYear(Button button) {
        mySongs.sort("Year");
        songIndex = 0;
        display();
    }

    /**
     * supports the genre button
     * @param button the genre button
     */
    public void clickedGenre(Button button) {
        mySongs.sort("Genre");
        songIndex = 0;
        display();
    }

    /**
     * supports the major button
     * @param button the major button
     */
    public void clickedMajor(Button button) {
        start.remove();
        coverShape.remove();
        legend.updateLegend("major");
        next.enable();
        songIndex = 0;
        previous.disable();
        answers = myPeople.getPercentageByMajor();
        display();
    }

    /**
     * supports the hobby button
     * @param button the hobby button
     */
    public void clickedHobby(Button button) {
        start.remove();
        coverShape.remove();
        legend.updateLegend("hobby");
        next.enable();
        songIndex = 0;
        previous.disable();
        answers = myPeople.getPercentageByHobby();
        display();
    }

    /**
     * supports the region button
     * @param button the region button
     */
    public void clickedRegion(Button button) {
        start.remove();
        coverShape.remove();
        legend.updateLegend("region");
        next.enable();
        songIndex = 0;
        previous.disable();
        answers = myPeople.getPercentageByRegion();
        display();
    }

    /**
     * supports the quit button
     * closes the window when clicked
     * @param button the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    public void display()
    {
        int answersIndex = songIndex * 2;
        if (mySongs.toList().size() - songIndex < 9)
        {
            for (int i = songIndex; i < mySongs.toList().size() - songIndex; i++)
            {
                graphs.get(i).setArtist(mySongs.toList().get(songIndex + i).getSongTitle());
                graphs.get(i).setSong(mySongs.toList().get(songIndex + i).getArtistName());
                graphs.get(i).setPinkLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setPinkRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setBlueLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setBlueRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setOrangeLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setOrangeRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setGreenLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setGreenRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
            }
        }
        else
        {
            for (int i = 0; i < 9; i++)
            {
               // System.out.println(answers[answersIndex]);
                graphs.get(i).setArtist(mySongs.toList().get(songIndex + i).getSongTitle());
                graphs.get(i).setSong(mySongs.toList().get(songIndex + i).getArtistName());
                graphs.get(i).setPinkLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setPinkRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setBlueLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setBlueRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setOrangeLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setOrangeRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setGreenLeftWidth((int) answers[answersIndex] / 2);
                answersIndex++;
                graphs.get(i).setGreenRightWidth((int) answers[answersIndex] / 2);
                answersIndex++;
            }
        }
    }


    /**
     * creates a new window for testing
     * @param args unused here
     */
    public static void main(String[] args) {
        new GUIDisplayWindow();
    }
}