package practice.task17;

public class Counter {

    private int value;
    private ValueHolder valueHolder;

    public Counter() {
        this(0);
    }

    public Counter(ValueHolder valueHolder) {
        this.valueHolder = valueHolder;
    }

    public Counter(int initialValue) {
        valueHolder = new ValueHolder(initialValue);
        this.value = initialValue;
    }

    public void increment() {
        valueHolder.setValue(valueHolder.getValue() + 1);
        value++;
    }

    public void decrement() {
        valueHolder.setValue(valueHolder.getValue()-1);
        value--;
    }

    public int getValue() {
        return valueHolder.getValue();
    }
//    public void setValueHolder(ValueHolder valueHolder){
//        this.valueHolder = valueHolder;
//    }
}
