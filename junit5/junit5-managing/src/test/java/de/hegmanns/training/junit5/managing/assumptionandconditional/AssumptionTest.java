package de.hegmanns.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssumptionTest {

    @Test
    public void disabledWithFollowingCode() {
        Assumptions.assumeTrue(false, "assume is working");
        // not proceed
        Assertions.assertTrue(false, "this will not fail ;)");
    }

    @Test
    @Disabled
    public void disabledWithoutProceedingAnyCode() {
        Assertions.assertTrue(false);// complete test is disabled
    }

    @Test
    @Disabled
    public void disabledByAssumingWithImportantTest() {
        int anyFirst = 1;
        int anySecond = 2;
        Integer sum = add(anyFirst, anySecond);
        Assumptions.assumeTrue(sum!=null);
        Assertions.assertEquals(5, sum);
    }

    @Test
    @Disabled
    public void assumingAndAssertionWithSupplier() {
        int anyFirst = 1;
        int anySecond = 2;
        Integer sum = add(anyFirst, anySecond);
        Assumptions.assumingThat(sum!=null, () -> {Assertions.assertEquals(5, sum);});
    }

    // only placed for training here
    private Integer add(Integer firstAddend, Integer secondAddend) {
        return 3;
    }

    @Test
    public void better_addResultsNeverNull() {
        int anyFirst = 4;
        int anySecond = 2;
        Assertions.assertNotNull(add(anyFirst, anySecond));
    }

    @Test
    public void better_calculatesCorrect() {
        int anyFirst = 1;
        int anySecond = 2;
        Assertions.assertEquals(3, add(anyFirst, anySecond));
    }
}
