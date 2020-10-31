package practice.task02;

public class ShortTermCalculator {

    public static String getShortTerm(String word) {
        if (word == null) {
            throw new NullPointerException("input is null");
        }
        if (word.length() <= 10) {
            return word;
        }
        return "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length() - 1);
    }
}
