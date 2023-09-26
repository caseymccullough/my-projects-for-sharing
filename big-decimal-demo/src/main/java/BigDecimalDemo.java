import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {

        System.out.println("with BigDecimal");
//
//        BigDecimal num1 = new BigDecimal("0.6");
//        BigDecimal num2 = new BigDecimal("3");
//
//        BigDecimal product = num1.multiply(num2);
//        System.out.println("Product: " + product);
//        BigDecimal expected = new BigDecimal("1.8");
//
//        if (product.equals(expected)){
//            System.out.println("values are equal");
//        } else {
//            System.out.println("values NOT equal");
//        }

        BigDecimal testValue = new BigDecimal("-1.0");

        int result = testValue.compareTo(BigDecimal.ZERO);
        System.out.println(result);





    }

}
