public class RectangularSolidDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to the testing program: ");
        RectangularSolid solid1 = new RectangularSolid(2, 3, 4);
        RectangularSolid solid2 = new RectangularSolid(); // default constructor

        System.out.println(solid1);
        System.out.println(solid2);

        int lengthSolid1 = solid1.getLength();
        int lengthSolid2 = solid2.getLength();

        System.out.println("first length: " + lengthSolid1);
        System.out.println("second length: " + lengthSolid2);

        solid1.setWidth(5);
        solid2.setWidth(6);

        System.out.println(solid1);
        System.out.println(solid2);

        System.out.println("volume of solid 1: " + solid1.getVolume());
        System.out.println("volume of solid 2: " + solid2.getVolume());
    }
}
