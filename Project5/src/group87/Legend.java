package group87;

import java.awt.Color;

import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;

/**
 * An average Legend.
 * @author Larissa Schneider (larissa6)
 * @author Simone Stewart (simone5)
 * @author Tara Amruthur (taraa2)
 * @version 2015.12.01
 */
public class Legend 
{
    private static int LEGEND_WIDTH = 130;
    private static int LEGEND_HEIGHT = 127;
    private int legendStartX;
    private int legendStartY;
    private Shape border;
    private Window window;
    private TextShape legend;
    private TextShape firstCategory;
    private TextShape secCategory;
    private TextShape thirdCategory;
    private TextShape fourthCategory;
    private TextShape songChar;
    private TextShape heard;
    private Shape division;
    private TextShape likes;
    
    /**
     * Creates a new legend.
     * @param myWindow The window where the legend will be created.
     * @param x The x-coordinate of the legend
     * @param y The y-coordinate of the legend.
     */
    public Legend(Window myWindow, int x, int y)
    {
        this.window = myWindow;
        this.legendStartX = x;
        this.legendStartY = y;
        border = new Shape(legendStartX, legendStartY, LEGEND_WIDTH,
                LEGEND_HEIGHT, Color.BLACK);
        border.setBackgroundColor(Color.WHITE);
        window.addShape(border);
        legend = new TextShape(legendStartX + 5,
                legendStartY + 5, "Legend");
        legend.setBackgroundColor(Color.WHITE);
        window.addShape(legend);
        firstCategory = new TextShape(legendStartX + 5, legendStartY + 20,
                "", Color.MAGENTA);
        firstCategory.setBackgroundColor(Color.WHITE);
        firstCategory.repaint();
        window.addShape(firstCategory);
        secCategory = new TextShape(legendStartX + 5, legendStartY + 35,
                "", Color.CYAN);
        secCategory.setBackgroundColor(Color.WHITE);
        window.addShape(secCategory);
        thirdCategory = new TextShape(legendStartX + 5, legendStartY + 50,
                "", Color.ORANGE);
        thirdCategory.setBackgroundColor(Color.WHITE);
        window.addShape(thirdCategory);
        fourthCategory = new TextShape(legendStartX + 5, legendStartY + 65,
                "", Color.GREEN);
        fourthCategory.setBackgroundColor(Color.WHITE);
        window.addShape(fourthCategory);
        songChar = new TextShape(legendStartX + 40, legendStartY + 80,
                "Song Title", Color.BLACK);
        songChar.setBackgroundColor(Color.WHITE);
        window.addShape(songChar);
        heard = new TextShape(legendStartX + 22, legendStartY + 100,
                "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.WHITE);
        window.addShape(heard);
        division = new Shape(legendStartX + 70, legendStartY + 95,
                5, 20, Color.BLACK);
        window.addShape(division);
        likes = new TextShape(legendStartX + 80, legendStartY + 100,
                "Likes", Color.BLACK);
        likes.setBackgroundColor(Color.WHITE);
        window.addShape(likes);
        window.moveToBack(border);
        window.repaint();
    }
    
    /**
     * Updates the legend.
     * @param representBy Determines what the legend will represent.
     */
    public void updateLegend(String representBy)
    {
        if (representBy.equals("hobby"))
        {
            firstCategory.setText("Read");
            secCategory.setText("Art");
            thirdCategory.setText("Sports");
            fourthCategory.setText("Music");
        }
        else if (representBy.equals("major"))
        {
            firstCategory.setText("Comp Sci");
            secCategory.setText("Other Eng");
            thirdCategory.setText("Math/CMDA");
            fourthCategory.setText("Other");
        }
        else if (representBy.equals("region"))
        {
            firstCategory.setText("Southeast");
            secCategory.setText("Northeast");
            thirdCategory.setText("US(other)");
            fourthCategory.setText("Non-US");
        }
        else
        {
            return;
        }
        firstCategory.repaint();
        secCategory.repaint();
        thirdCategory.repaint();
        fourthCategory.repaint();
    }

}
