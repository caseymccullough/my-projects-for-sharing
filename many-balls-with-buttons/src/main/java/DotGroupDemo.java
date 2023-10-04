import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

/*********************************************************************************


 ***********************************************************************************/
public class DotGroupDemo extends JFrame {
    // DATA:
    private static DotGroup redDots;
    private static DotGroup blueDots;

    private static JButton redToggleButton;
    private static JButton blueToggleButton;

    private static final int MAX_WIDTH = 1000;        // Window size
    private static final int MAX_HEIGHT = 800;        // Window size
    private static final Color BACKGROUND_COLOR = Color.white;

    // METHODS:

    /**
     * main -- Start up the window.
     *
     * @param    args
     */
    public static void main(String args[]) {
        // Create the window.
        DotGroupDemo dgd = new DotGroupDemo();
    }

    /**
     * ManyBalls constructor: create the one Ball and simulate the "clock"
     */
    public DotGroupDemo() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        redToggleButton = new JButton("RED");
        redToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redDots.changeVisibility();
                DotGroupDemo.this.actionPerformed();
            }
        });

        blueToggleButton = new JButton("BLUE");
        blueToggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                blueDots.changeVisibility();
                DotGroupDemo.this.actionPerformed();
            }
        });
        panel.add(redToggleButton);
        panel.add(blueToggleButton);

        this.getContentPane().add(panel);

        int[] redX = {200, 300, 400};
        int[] redY = {200, 300, 400};
        redDots = new DotGroup(redX, redY, Color.RED);

        int[] blueX = {250, 350, 450};
        int[] blueY = {450, 350, 250};
        blueDots = new DotGroup(blueX, blueY, Color.BLUE);




        // Show the window with the ball in its initial position.
        //	Note that these are called without the mb. in front.
        //	We'll discuss why in class.
        setSize(MAX_WIDTH, MAX_HEIGHT);
        setVisible(true);

    }


    private void actionPerformed() {

        // Update the window.
        repaint();
    }

    /**
     * paint 		draw the window
     *
     * @param g Graphics object to draw on
     */
    public void paint(Graphics g) {
        // Clear the window.
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, MAX_WIDTH, MAX_HEIGHT);

        // Draw each ball.
        redDots.draw(g);
        blueDots.draw(g);

    }
}
