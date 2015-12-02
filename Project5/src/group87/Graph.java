package group87;

import java.awt.Color;

import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * An average graph.
 * @author Larissa Schneider (larissa6)
 * @author Simone Stewart (simone5)
 * @author Tara Amruthur (taraa2)
 * @version 2015.12.01
 */
public class Graph 
{
    private String song;
    private String artist;
    private int width;
    TextShape title;
    TextShape artistListing;
    Shape pinkLeft;
    Shape blueLeft;
    Shape orangeLeft;
    Shape greenLeft;
    Shape divisor;
    Shape pinkRight;
    Shape blueRight;
    Shape orangeRight;
    Shape greenRight;
    Window window;
    
    /**
     * Creates a new graph
     * @param x The x-coordinate 
     * @param y The y-coordinate
     * @param song The song title
     * @param artist The artist's name
     * @param window The window to add the new graph into.
     */
    public Graph(int x, int y, String song,
            String artist, Window window)
    {
        this.song = song;
        this.artist = artist;
        width = 50;
        this.window = window;
        title = new TextShape(x, y, song, Color.BLACK);
        title.setBackgroundColor(Color.WHITE);
        String tempString = "by " + artist;
        artistListing = new TextShape(x, y + 15, 
                tempString, Color.BLACK);
        artistListing.setBackgroundColor(Color.WHITE);
        pinkLeft = new Shape(x, y + 40, width, 5, Color.MAGENTA);
        blueLeft = new Shape(x, y + 45, width, 5, Color.CYAN);
        orangeLeft = new Shape(x, y + 50, width, 5, Color.ORANGE);
        greenLeft = new Shape(x, y + 55, width, 5, Color.GREEN);
        divisor = new Shape(x + 50, y + 40, 5, 20, Color.BLACK);
        pinkRight = new Shape(x + 50, y + 40, width, 5, Color.MAGENTA);
        blueRight = new Shape(x + 50, y + 45, width, 5, Color.CYAN);
        orangeRight = new Shape(x + 50, y + 50, width, 5, Color.ORANGE);
        greenRight = new Shape(x + 50, y + 55, width, 5, Color.GREEN);
        window.addShape(title);
        window.addShape(artistListing);
        window.addShape(pinkLeft);
        window.addShape(blueLeft);
        window.addShape(orangeLeft);
        window.addShape(greenLeft);
        window.addShape(pinkRight);
        window.addShape(blueRight);
        window.addShape(orangeRight);
        window.addShape(greenRight);
        window.addShape(divisor);
        window.moveToFront(divisor);
    }
    
    /**
     * Gets the song name.
     * @return The song name.
     */
    public String getSong()
    {
        return song;
    }
    /**
     * Sets the song name.
     * @param song The song name.
     */
    
    public void setSong(String song)
    {
        this.song = song;
        title.setText(song);
        title.repaint();
    }
    
    /**
     * Gets the artist's name.
     * @return The artist's name.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Sets the artist's name.
     * @param artist The artist's name.
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
        artistListing.setText("by " + artist);
        artistListing.repaint();
    }
    
    /**
     * Sets the width of the left pink bar.
     * @param width The width.
     */
    public void setPinkLeftWidth(int width)
    {
        int x = pinkLeft.getX();
        int y = pinkLeft.getY();
        Color color = pinkLeft.getForegroundColor();
        pinkLeft.remove();
        pinkLeft = new Shape(x + 50 - width, y, width, 5, color);
        window.addShape(pinkLeft);
    }
    
    /**
     * Sets the width of the left blue bar.
     * @param width The width.
     */
    public void setBlueLeftWidth(int width)
    {
        int x = blueLeft.getX();
        int y = blueLeft.getY();
        Color color = blueLeft.getForegroundColor();
        blueLeft.remove();
        blueLeft = new Shape(x + 50 - width, y, width, 5, color);
        window.addShape(blueLeft);
    }
    
    /**
     * Sets the width of the left orange bar.
     * @param width The width.
     */
    public void setOrangeLeftWidth(int width)
    {
        int x = orangeLeft.getX();
        int y = orangeLeft.getY();
        Color color = orangeLeft.getForegroundColor();
        orangeLeft.remove();
        orangeLeft = new Shape(x + 50 - width, y, width, 5, color);
        window.addShape(orangeLeft);
    }
    
    /**
     * Sets the width of the left green bar.
     * @param width The width.
     */
    public void setGreenLeftWidth(int width)
    {
        int x = greenLeft.getX();
        int y = greenLeft.getY();
        Color color = greenLeft.getForegroundColor();
        greenLeft.remove();
        greenLeft = new Shape(x + 50 - width, y, width, 5, color);
        window.addShape(greenLeft);
    }
    
    /**
     * Sets the width of the right pink bar.
     * @param width The width.
     */
    public void setPinkRightWidth(int width)
    {
        int x = pinkRight.getX();
        int y = pinkRight.getY();
        Color color = pinkRight.getForegroundColor();
        pinkRight.remove();
        pinkRight = new Shape(x, y, width, 5, color);
        window.addShape(pinkRight);
    }
    
    /**
     * Sets the width of the right blue bar.
     * @param width The width.
     */
    public void setBlueRightWidth(int width)
    {
        int x = blueRight.getX();
        int y = blueRight.getY();
        Color color = blueRight.getForegroundColor();
        blueRight.remove();
        blueRight = new Shape(x, y, width, 5, color);
        window.addShape(blueRight);
    }
    
    /**
     * Sets the width of the right orange bar.
     * @param width The width.
     */
    public void setOrangeRightWidth(int width)
    {
        int x = orangeRight.getX();
        int y = orangeRight.getY();
        Color color = orangeRight.getForegroundColor();
        orangeRight.remove();
        orangeRight = new Shape(x, y, width, 5, color);
        window.addShape(orangeRight);
    }
    
    /**
     * Sets the width of the green right bar.
     * @param width The width.
     */
    public void setGreenRightWidth(int width)
    {
        int x = greenRight.getX();
        int y = greenRight.getY();
        Color color = greenRight.getForegroundColor();
        greenRight.remove();
        greenRight = new Shape(x, y, width, 5, color);
        window.addShape(greenRight);
    }
}
