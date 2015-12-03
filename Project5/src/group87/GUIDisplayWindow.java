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
    private PeopleList myPeople;
    private SongList mySongs;
    private int peopleIndex;
    private int songIndex;
    private Shape coverShape;
    private TextShape start;
    private Legend legend;
    private Button previous;
    private Button next;

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
        //Adds Buttons to the top of the window
        previous = new Button("<-- Prev");
        previous.onClick(this, "clickedQuit");
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
    }

    //Methods -----------------------------------------------------------------
    /**
     * supports the previous button
     * @param button the previous button
     */
    public void clickedPrevious(Button button) {
        //TODO go to the previous page
        //TODO disable if at the first page
    }

    /**
     * supports the next button
     * @param button the next button
     */
    public void clickedNext(Button button) {
        //TODO go to next page
        //TODO disable if at the last page
    }

    /**
     * supports the artist button
     * @param button the artist button
     */
    public void clickedArtist(Button button) {
        //TODO sort by artist
    }

    /**
     * supports the song button
     * @param button the song button
     */
    public void clickedSong(Button button) {
        //TODO sort by song name
    }

    /**
     * supports the year button
     * @param button the year button
     */
    public void clickedYear(Button button) {
        //TODO sort by year
    }

    /**
     * supports the genre button
     * @param button the genre button
     */
    public void clickedGenre(Button button) {
        //TODO sort by genre
    }

    /**
     * supports the major button
     * @param button the major button
     */
    public void clickedMajor(Button button) {
        start.remove();
        coverShape.remove();
        legend.updateLegend("major");
    }

    /**
     * supports the hobby button
     * @param button the hobby button
     */
    public void clickedHobby(Button button) {
        start.remove();
        coverShape.remove();
        legend.updateLegend("hobby");
    }

    /**
     * supports the region button
     * @param button the region button
     */
    public void clickedRegion(Button button) {
        start.remove();
        coverShape.remove();
        legend.updateLegend("region");
    }

    /**
     * supports the quit button
     * closes the window when clicked
     * @param button the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * updates the legend in the window
     * @param representBy the aspect of students the data is sorted by
     */


    /**
     * creates a new window for testing
     * @param args unused here
     */
    public static void main(String[] args) {
        new GUIDisplayWindow();
    }
}