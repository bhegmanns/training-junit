package practice.task04;

public class BoundedCounter extends Counter{

    private int minimum;
    private int maximum;


    public BoundedCounter(int initial, int minimum, int maximum) {
        super(initial);
        this.minimum = minimum;
        this.maximum = maximum;
    }

    @Override
    public int increment() {

        if (getValue() < maximum) {
            return super.increment();
        }
        return getValue();
    }

    @Override
    public int decrement() {
        if (getValue() > minimum) {
            return super.decrement();
        }
        return getValue();
    }
}
