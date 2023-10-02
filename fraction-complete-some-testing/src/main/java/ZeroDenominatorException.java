public class ZeroDenominatorException extends Exception{
    public ZeroDenominatorException() {
        super("You cannot instantiate a fraction with a zero denominator");
    }
}
