package de.hegmanns.training.junit5.extension.training.junit5.practice.task03;

public class LongTimeService {

    private static final long MIN_TIME_FOR_THINKING = 600;
    private static final long MAX_TIME_FOR_THINKING = 1000;

    /**
     * Calculates the sum of the given numbers.
     * @param firstNumberAsString
     * @param secondNumberAsString

     * @return sum of the numbers
     */
    public int add(String firstNumberAsString, String secondNumberAsString) {
        int firstNumber = convertStringToNumber(firstNumberAsString);
        int secondNumber = convertStringToNumber(secondNumberAsString);

        int sum = firstNumber + secondNumber;

        return sum;
    }

    private int convertStringToNumber(String numberAsString) {
        try {
            long dynamicTimeForThinking = (long) (Math.random() * ((MAX_TIME_FOR_THINKING - MIN_TIME_FOR_THINKING) / 2));
            long totalTimeForThinking = (MIN_TIME_FOR_THINKING + dynamicTimeForThinking)/2;
            Thread.sleep(totalTimeForThinking);
        } catch (InterruptedException e) {
            throw new RuntimeException("oh, interrupted", e);
        }

        return Integer.parseInt(numberAsString);
    }
}
