import java.awt.*;

public class DotGroup {
    private Dot[] dots;
    private Color color;

    private boolean isVisible;

    public DotGroup (int[] xPos, int[] yPos, Color color){

        this.dots = new Dot[xPos.length * yPos.length];
        int dotPos = 0;
        for (int x = 0; x < xPos.length; x++){
            for (int y = 0; y < yPos.length; y++) {
                Dot dot = new Dot(xPos[x], yPos[y], color);
                dots[dotPos] = dot;
                dotPos++;
            }
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
