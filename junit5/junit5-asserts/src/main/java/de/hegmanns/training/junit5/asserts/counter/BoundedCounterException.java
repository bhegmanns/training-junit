package de.hegmanns.training.junit5.asserts.counter;

public class BoundedCounterException extends RuntimeException{

    public <T> BoundedCounterException(T currentValue, T expectedValue){
        super("could not walk from " + currentValue.toString() + " to " + expectedValue.toString());
    }

    private BoundedCounterException(String message) {
        super(message);
    }

    public  static  <T> BoundedCounterException create(T currentValue, T expectedValue) {
        return new BoundedCounterException(currentValue, expectedValue);
    }

    public static <T> BoundedCounterException createFromExpectedValue(T expectedValue) {
        return new BoundedCounterException("could not walk to " + expectedValue.toString());
    }

    public static <T> BoundedCounterException createFromCurrentValue(T currentValue) {
        return new BoundedCounterException("could not walk from " + currentValue);
    }
}
