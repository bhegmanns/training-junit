package de.hegmanns.training.junit.special;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WithAssertionsTest {

    @Test
    public void expectedException() {
        NullPointerException expectedException = Assertions.assertThrows(NullPointerException.class, () -> {
            Object o = null;
            o.toString();
        });

        // here you can work with get exception
    }

    @Test
    public void expectedSame() {
        Integer a = 12;
        Integer b = a;

        Assertions.assertSame(b, a);
    }

    @Test
    public void expectedLines() {
        List<String> lines = Stream.of("hello", "great", "world").collect(Collectors.toList());

        Assertions.assertLinesMatch(Arrays.asList("hello", "great", "world"), lines);
    }

    @Test
    public void expectedNull() {
        Integer a = null;
        Integer b = 12;

        Assertions.assertNull(a);
        Assertions.assertNotNull(b, "not null expected");
        Assertions.assertNotNull(b, () -> "not null expected");
    }

    @Test
    public void expectedIterable() {
        List<String> lines = Stream.of("hello", "great", "world").collect(Collectors.toList());

        Assertions.assertIterableEquals(Arrays.asList("hello", "great", "world"), lines);
    }


}
