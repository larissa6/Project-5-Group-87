package group87;

import CS2114.TextShape;
import java.awt.Color;
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
 *  @author Simone Stewart (simone5), Larissa Schneider (larissa6),
 *  Tara (taraa2)
 *  @version 2015.11.14
 */
public class GUIDisplayWindow
{
    //Fields ------------------------------------------------------------------
    private Window window;
    private static int LEGEND_WIDTH = 150;
    private static int LEGEND_HEIGHT = 200;
    private int legendStartX;
    private int legendStartY;

    //Constructor--------------------------------------------------------------
    /**
     * creates a new DisplayWindow
     */
    public GUIDisplayWindow() {
        window = new Window("Project 5");
        legendStartX = window.getWidth() - LEGEND_WIDTH;
        legendStartY = window.getHeight() - LEGEND_HEIGHT;

        //Adds Buttons to the top of the window
        Button previous = new Button("<-- Prev");
        previous.onClick(this);
        window.addButton(previous, WindowSide.NORTH);
        Button artist = new Button("Sort by Artist Name");
        previous.disable();
        artist.onClick(this);
        window.addButton(artist, WindowSide.NORTH);
        Button song = new Button("Sort by Song Title");
        song.onClick(this);
        window.addButton(song, WindowSide.NORTH);
        Button year = new Button("Sort by Release Year");
        year.onClick(this);
        window.addButton(year, WindowSide.NORTH);
        Button genre = new Button("Sort by Genre");
        genre.onClick(this);
        window.addButton(genre, WindowSide.NORTH);
        Button next = new Button("Next -->");
        next.onClick(this);
        window.addButton(next, WindowSide.NORTH);

        //Adds Buttons to the bottom of the window
        Button hobby = new Button("Represent Hobby");
        hobby.onClick(this);
        window.addButton(hobby, WindowSide.SOUTH);
        Button major = new Button("Represent Major");
        major.onClick(this);
        window.addButton(major, WindowSide.SOUTH);
        Button region = new Button("Represent Region");
        region.onClick(this);
        window.addButton(region, WindowSide.SOUTH);
        Button quit = new Button("Quit");
        quit.onClick(this);
        window.addButton(quit, WindowSide.SOUTH);

        //creates the initial legend
        updateLegend("hobby", "song");
        sampleGraph();
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
        //TODO create graphs based on major
    }

    /**
     * supports the hobby button
     * @param button the hobby button
     */
    public void clickedHobby(Button button) {
        //TODO create graphs based on hobby
    }

    /**
     * supports the region button
     * @param button the region button
     */
    public void clickedRegion(Button button) {
        //TODO create graphs based on region
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
     * @param student the aspect of students the data is sorted by
     * @param song the aspect of the song the data is sorted by
     */
    public void updateLegend(String student, String song) {
        /*Shape border = new Shape(legendStartX, legendStartY, LEGEND_WIDTH,
            LEGEND_HEIGHT, Color.BLACK);
        border.setBackgroundColor(Color.WHITE);
        window.addShape(border);
        */

        TextShape legend = new TextShape(legendStartX + 5, legendStartY + 5,
            "Legend");
        legend.setBackgroundColor(Color.WHITE);
        window.addShape(legend);
        //TODO add colored text shapes based on student to determine what they
        //should be
        TextShape read = new TextShape(legendStartX + 5, legendStartY + 20,
            "Read", Color.MAGENTA);
        read.setBackgroundColor(Color.WHITE);
        window.addShape(read);
        TextShape art = new TextShape(legendStartX + 5, legendStartY + 35,
            "Art", Color.CYAN);
        art.setBackgroundColor(Color.WHITE);
        window.addShape(art);
        TextShape sports = new TextShape(legendStartX + 5, legendStartY + 50,
            "Sports", Color.ORANGE);
        sports.setBackgroundColor(Color.WHITE);
        window.addShape(sports);
        TextShape music = new TextShape(legendStartX + 5, legendStartY + 65,
            "Music", Color.GREEN);
        music.setBackgroundColor(Color.WHITE);
        window.addShape(music);

        //Graph Legend
        TextShape songChar = new TextShape(legendStartX + 10, legendStartY + 80,
            song, Color.BLACK);
        songChar.setBackgroundColor(Color.WHITE);
        window.addShape(songChar);
        TextShape heard = new TextShape(legendStartX - 25, legendStartY + 100,
            "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        Shape division = new Shape(legendStartX + 20, legendStartY + 95,
            5, 20, Color.BLACK);
        window.addShape(division);
        TextShape likes = new TextShape(legendStartX + 33, legendStartY + 100,
            "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
    }

    /**
     * Makes a sample graph for the window
     */
    public void sampleGraph() {
        int x = 20;
        int y = 20;
        TextShape title = new TextShape(x, y, "All You Need is Love",
            Color.BLACK);
        title.setBackgroundColor(Color.WHITE);
        TextShape artist = new TextShape(x, y + 15, "by The Beatles",
            Color.BLACK);
        artist.setBackgroundColor(Color.WHITE);
        Shape pink = new Shape(x, y + 40, 100, 5, Color.MAGENTA);
        Shape blue = new Shape(x, y + 45, 100, 5, Color.CYAN);
        Shape orange = new Shape(x, y + 50, 100, 5, Color.ORANGE);
        Shape green = new Shape(x, y + 55, 100, 5, Color.GREEN);
        Shape divisor = new Shape(x + 50, y + 40, 5, 20, Color.BLACK);

        window.addShape(title);
        window.addShape(artist);
        window.addShape(pink);
        window.addShape(blue);
        window.addShape(orange);
        window.addShape(green);
        window.addShape(divisor);
        window.moveToFront(divisor);
    }

    /**
     * creates a new window for testing
     * @param args unused here
     */
    public static void main(String[] args) {
        new GUIDisplayWindow();
    }
}