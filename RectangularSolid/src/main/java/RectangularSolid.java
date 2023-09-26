public class RectangularSolid {
    private int length;
    private int width;
    private int height;

    // Constructor(s)
    public RectangularSolid (int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public RectangularSolid (){
        this.length = 1;
        this.width = 1;
        this.height = 1;
    }

    // Getters

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Setters

    public void setLength (int length){
        if (length >= 0) {
            this.length = length;
        } else {
            System.out.println("Invalid value for length. No change");
        }

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVolume() {
        int volume = length * width * height;
        return volume;
    }


    public String toString(){
        String s = "Length: " + length + ", Width: " + width + ", Height: " + height;
        return s;
    }
}
