package practice.task17;

public class BoundedCounter extends Counter {
    private int minimum;
    private int maximum;


    public BoundedCounter(ValueHolder valueHolder) {
        super(valueHolder);
    }

    public BoundedCounter() {
        this(0, 0, 10);
    }


    public BoundedCounter(int initialValue, int minimum, int maximum) {
        super(initialValue);
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public void increment() {
        if (getValue() < maximum) {
            super.increment();
        }
    }

    @Override
    public void decrement() {
        if (getValue() > minimum) {
            super.decrement();
        }
    }

}
