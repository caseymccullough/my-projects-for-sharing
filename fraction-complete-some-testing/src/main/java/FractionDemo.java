public class FractionDemo
{
    public static void main(String[] args) {

        Fraction f1 = null; // calls to what?
        try {
            f1 = new Fraction (2,3);
        } catch (ZeroDenominatorException e) {
            e.printStackTrace();
        }
        Fraction f2 = null;
        try {
            f2 = new Fraction (2, 3);
        } catch (ZeroDenominatorException e) {
            e.printStackTrace();
        }
        Fraction f3 = f1;


        if (f1.equals(f2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
    
}