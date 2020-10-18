package de.hegmanns.training.junit5.asserts.counter;

public class NumericCounter implements Counter<Integer>{

    private int value;

    public NumericCounter() {
    }

    public NumericCounter(int value) {
        this.value = value;
    }

    @Override
    public void increment() {
        setNewValue(getValue()+1);
    }

    @Override
    public void decrement() {
        setNewValue(getValue()-1);
    }

    protected void setNewValue(int newValue) {
        this.value = newValue;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public static class CounterFl{

        private int initialValue;

        public static CounterFl create(int initialValue) {
            CounterFl counterFl = new CounterFl();
            counterFl.initialValue = initialValue;
            return counterFl;
        }


        public NumericCounter create() {
                return new NumericCounter(initialValue);
        }
    }
}
