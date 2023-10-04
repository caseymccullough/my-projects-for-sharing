import java.awt.*;

public class DotGroup {
    private Dot[] dots;
    private Color color;

    private boolean isVisible;

    public DotGroup (int[] xPos, int[] yPos, Color color){

        this.dots = new Dot[xPos.length];
        for (int i = 0; i < xPos.length; i++){
            Dot dot = new Dot (xPos[i], yPos[i], color);
            dots[i] = dot;
        }
        this.color = color;
        this.isVisible = true;
    }

    public void changeVisibility () {
        this.isVisible = !this.isVisible;
    }

    public void draw(Graphics g)
    {
        if (isVisible) {
            for (Dot dot : dots){
                dot.draw(g);
            }
        }
    }


}
