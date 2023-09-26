import java.math.BigDecimal;

public class BigDecimalDemoFinal {
    public static void main(String[] args) {

        double val = 0.6 * 3;

        if (val == 1.8) {
            System.out.println("values are equal");
        } else {
            System.out.println("values are NOT equal");
        }

        System.out.println(val);

        System.out.println("with BigDecimal");
        BigDecimal num1 = new BigDecimal("0.6");
        BigDecimal num2 = new BigDecimal("3");

        BigDecimal product = num1.multiply(num2);

        System.out.println("Product: " + product);

        BigDecimal expected = new BigDecimal("1.8");

        if (product.equals(expected)) {
            System.out.println("values are equal");
        } else {
            System.out.println("values are NOT equal");
        }

        BigDecimal testValue = new BigDecimal ("0.0");
        int result = testValue.compareTo(BigDecimal.ZERO);
        System.out.println(result);

    }

}
