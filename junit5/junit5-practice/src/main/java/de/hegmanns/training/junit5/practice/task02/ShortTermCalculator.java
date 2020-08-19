package de.hegmanns.training.junit5.practice.task02;

public class ShortTermCalculator {

    public static String getShortTerm(String word) {
        if (word == null) {
            throw new NullPointerException("input is null");
        }
        return "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length() - 1);
    }
}
