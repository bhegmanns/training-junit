package de.hegmanns.training.junit5.extension.training.junit5.practice.task03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.task03.LongTimeService;
import practice.task03.StringToIntConverter;

public class LongTimeServiceWithShortProxyTest {
    private static class ShortProxy implements StringToIntConverter {
        private int[] convertResults;
        private int countConverts = 0;

        public ShortProxy(int firstConvert, int secondConvert) {
            convertResults = new int[2];

            convertResults[0] = firstConvert;
            convertResults[1] = secondConvert;
        }

        @Override
        public int convertFromString(String numberAsString) {
            return convertResults[countConverts++];
        }
    }

    @Test
    public void tryItInShortTime() {
        LongTimeService longTimeService = new LongTimeService();
        longTimeService.setStringToIntConverter(new ShortProxy(1, 1));

        Assertions.assertEquals(2, longTimeService.add("anyFirstNumber", "anySecondNumber"));
    }
}
