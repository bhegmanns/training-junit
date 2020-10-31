package de.hegmanns.training.junit5.extension.training.junit.special.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class XetraTest {

    private Ordercheck ordercheck;

    @ParameterizedTest
    @EnumSource//(XetraType.class)
    public void limitOrder(XetraType type) {

    }

    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.INCLUDE, names = {})
    public void auctionOnlyOrder(XetraType type) {

    }

    @ParameterizedTest
    @EnumSource(XetraType.class)
    public void marketOrder(XetraType type) {

    }


    static class Order{}
    static class Ordercheck{
        public boolean checkOrder(Order order){
            return false;
        }
    }

    public void checkXetratypes(XetraTestCase testCase) {

    }



    static class XetraTestCase{
        XetraType type;
        String[] obligeContent;

    }
}
