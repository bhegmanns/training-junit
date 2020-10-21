package de.hegmanns.training.junit5.cucumber;

public class Counter {

    private int initialValue;
    private int value;

    public Counter(int initialValue) {
        this.value = initialValue;
        this.initialValue = value;
    }

    public int getValue() {
        return value;
    }

    /**
     *
     * @param command any of "+", "-", "0"
     */
    public void doCommand(String command) {
        if (command.equals("+")) {
            value++;
        }else{
            if (command.equals("-")) {
                value--;
            }else{
                if (command.equals("0")) {
                    value = initialValue;
                }
            }
        }
    }
}
