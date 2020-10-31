package de.hegmanns.training.junit5.extension.training.junit5.tdd.example;

public class StringCalculator {
    public static int calculate(String string) {
        if (isParsableToInteger(string)) {
            String[] splitNumbers = string.replace(" ", "").split(",|\\r\\n");
            if (splitNumbers.length <= 3) {

                int sum = 0;
                for (String splitNumber : splitNumbers) {
                    int parsedNumber = 0;
                    try{parsedNumber = Integer.parseInt(splitNumber);}catch(NumberFormatException e){};
                    if (parsedNumber <= 1000) {
                        sum += parsedNumber;
                    }
                }
                return sum;
            }

        }

        return 0;
    }

    private static boolean isParsableToInteger(String string) {

        if (string!=null && string.contains("-")) {
            throw new NumberFormatException("");
        }
        boolean isParsable = !(string == null || string.isEmpty());
        return isParsable;
    }
}
