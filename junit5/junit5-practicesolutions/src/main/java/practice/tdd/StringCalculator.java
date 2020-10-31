package practice.tdd;

import java.util.Arrays;

public class StringCalculator {

    public static int calculate(String string){
        if (isParsableIntoInteger(string)){
                String[] parts = splitToParsableNumbers(string, ",|\\r\\n");
                Arrays.stream(parts).mapToInt(Integer::parseInt).filter((i) -> i<0).findAny().ifPresent((i) -> {throw new RuntimeException("");});
                return Arrays.stream(parts).map(Integer::parseInt).mapToInt(Integer::intValue).filter((i) -> i<=1000).sum();
        }
        return 0;
    }

    private static String[] splitToParsableNumbers(String string, String s) {
        return string.split(s);
    }

    private static boolean isParsableIntoInteger(String string) {
        return string != null && !string.isEmpty();
    }
}
