package de.hegmanns.training.junit5.asserts.counter;

public class BoundedNumericCounter extends NumericCounter{

    private int minimalValue;
    private int maximumValue;

    BoundedNumericCounter(int minimalValue, int maximumValue, int value) {
        super(value);
        this.minimalValue = minimalValue;
        this.maximumValue = maximumValue;
    }

    public int getMinimalValue() {
        return minimalValue;
    }

    public int getMaximumValue() {
        return maximumValue;
    }

    @Override
    protected void setNewValue(int newValue) {
        if (newValue > maximumValue || newValue < minimalValue) {
            throw new BoundedCounterException(getValue(), newValue);
        }
        super.setNewValue(newValue);
    }

    public static class BoundedCounterFl{

        private int initialValue;
        private Integer minimum;
        private Integer maximum;

        public static BoundedNumericCounter.BoundedCounterFl create(int initialValue) {
            BoundedNumericCounter.BoundedCounterFl counterFl = new BoundedNumericCounter.BoundedCounterFl();
            counterFl.initialValue = initialValue;
            return counterFl;
        }

        public BoundedNumericCounter.BoundedCounterFl withMaxBound(int maximum) {
            this.maximum = maximum;
            return this;
        }

        public BoundedNumericCounter.BoundedCounterFl withMinBound(int minimum) {
            this.minimum = minimum;
            return this;
        }

        public BoundedNumericCounter create() {
            if (minimum == null && maximum == null) {
                return new BoundedNumericCounter(Integer.MIN_VALUE, Integer.MAX_VALUE, initialValue);
            }else{
                if (minimum == null) {
                    minimum = Integer.MIN_VALUE;
                }
                if (maximum == null) {
                    maximum = Integer.MAX_VALUE;
                }
                if (minimum > maximum) {
                    int tempMinimum = minimum;
                    minimum = maximum;
                    maximum = tempMinimum;
                }
                initialValue = Math.max(minimum, initialValue);
                initialValue = Math.min(maximum, initialValue);
                return new BoundedNumericCounter(minimum, maximum, initialValue);
            }
        }
    }
}
