//*************************************
// NightSky.java
// Casey McCulloug
// shows random array of buildings
// Modified 8/31/15
// ************************************

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.util.Random;

public class NightSky extends JFrame {

    private final static int SCREEN_WIDTH = 1200;
    private final static int SCREEN_HEIGHT = 650;

    private final static String CITY_NAME = "Cleveland";
    private final int NUM_BUILDINGS = 15;
    private final int NUM_STARS = 1000;
    private final int GROUND_LEVEL = 100;
    private final int MIN_WIDTH = 25;

    private Building[] cityBuildings;
    private Star[] stars;

    /**
     * main -- Start up the window.
     *
     * @param    args
     */
    public static void main(String args[]) {
        // Create the window.
        NightSky ns = new NightSky();
    }

    public NightSky() {

        Random generator = new Random();

        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);

        cityBuildings = new Building[NUM_BUILDINGS];
        stars = new Star[NUM_STARS];

        int count;
        int x, y, height, width;

        // generate Star objects
        for (count = 0; count < NUM_STARS; count++) {
            x = generator.nextInt(SCREEN_WIDTH);
            y = generator.nextInt(SCREEN_HEIGHT - GROUND_LEVEL);
            stars[count] = new Star(x, y);
        }

        // Generate Building objects
        for (count = 0; count < NUM_BUILDINGS; count++) {
            x = generator.nextInt(SCREEN_WIDTH) - MIN_WIDTH;
            height = generator.nextInt(SCREEN_HEIGHT - 250) + 50;
            // height has minimum of 50, maximum of 50 short of top of screen.

            y = SCREEN_HEIGHT - GROUND_LEVEL - height;
            width = generator.nextInt(180) + 50;
            cityBuildings[count] = new Building(x, y, width, height);
        }

        //setBackground (new Color (177, 177, 255));


    }

    public void paint(Graphics g) {

        int i;

        g.setColor(new Color (127, 127, 255));
        g.drawRect(0,0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // produces a series of rectangles that shift sky color
        // from 0, 0, 0  black
        // to 127, 127, 255 blue
        for (int j = 0; j < 256 / 2; j++) {
            g.setColor(new Color(j, j, 2 * j));
            g.fillRect(0, j * 4, SCREEN_WIDTH, 4);

        }


        for (i = 0; i < NUM_STARS; i++) {
            stars[i].draw(g);
        }

        // Draws the sun-- do before drawing buildings!
        g.setColor(new Color(250, 100, 100));
        g.fillOval(120, 90, 50, 50);


        for (i = 0; i < NUM_BUILDINGS; i++) {
            cityBuildings[i].draw(g);

        }


        // Draw the ground
        g.setColor(Color.darkGray);
        g.fillRect(0, SCREEN_HEIGHT - GROUND_LEVEL, SCREEN_WIDTH, GROUND_LEVEL);

        // Name the city
        g.setColor(Color.yellow);
        g.setFont(new Font("Garamond", Font.ITALIC, 28));
        g.drawString(CITY_NAME + " at dusk", 500, 100);

    }


}

