package de.hegmanns.training.junit.special.template;

public class NumberCheck {

    private boolean oddAsPreferred;
    public void setOddAsPreferred(boolean oddAsPreferred) {
        this.oddAsPreferred = oddAsPreferred;
    }

    public boolean isPreferred(int number) {
        if (!oddAsPreferred) {
            return number % 2 == 0;
        }else{
            return number % 2 != 0;
        }
    }
}
