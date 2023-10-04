import java.awt.*;

class Dot
{
	private static final Font ID_FONT = new Font("Roboto", Font.PLAIN, 18);
	private static final int RADIUS = 15;


	// Instance data:
	private int x, y;		// Center of the ball
	private Color color;	// Color of the ball

	// METHODS:

	/**
	 * Ball constructor initializes the Ball object
	 *
	 * @param x		x coordinate of center
	 * @param y		y coordinate of center

	 * @param color	color
	 */
	public Dot(int x, int y, Color color)
	{

		this.x = x;
		this.y = y;
		this.color = color;


	}



	/**
	 * Draw the dot.
	 * 
	 * @param g			Graphics object in which to draw
	 */
	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);

		g.setFont(ID_FONT);
		g.setColor(Color.WHITE);
		g.drawString("X" , x - 5, y + 5);
	}
}
			