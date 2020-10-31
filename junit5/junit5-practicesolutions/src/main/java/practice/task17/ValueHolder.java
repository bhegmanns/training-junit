package practice.task17;

public class ValueHolder {
    int value;

    public ValueHolder(int currentValue) {
        this.value = currentValue;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }
}
