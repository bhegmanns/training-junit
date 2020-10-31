package de.hegmanns.training.junit5.extension.training.junit.special.template;

public class NumberCheckTestCase {

    private boolean oddPreferred;
    private int number;
    private boolean preferred;

    public NumberCheckTestCase(boolean oddPreferred, int number, boolean preferred) {
        this.oddPreferred = oddPreferred;
        this.number = number;
        this.preferred = preferred;
    }

    public boolean isOddPreferred() {
        return oddPreferred;
    }

    public void setOddPreferred(boolean oddPreferred) {
        this.oddPreferred = oddPreferred;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }
}
