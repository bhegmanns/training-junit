package de.hegmanns.training.junit5.extension.training.junit5.practice.task06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import practice.task06.Cube;
import practice.task06.CubeMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class CubeModeTest {

    @ParameterizedTest
    @EnumSource(CubeMode.class)
    public void foo(CubeMode mode) {
        Cube cube = new Cube(mode);
        Map<Integer, Integer> counts = new HashMap<>();

        IntStream.range(0, 120).map((i) -> cube.getNext()).forEach((i) -> {
            Integer count = counts.get(i);
            if (count==null){count = 0;}
            count++;
            counts.put(i, count);
        });

        switch (mode) {
            case FAIR:
                Assertions.assertFalse(counts.entrySet().stream().mapToInt((e) -> e.getValue()).filter((i) -> i<=10).findFirst().isPresent());
                break;
            case UNFAIR:
                Assertions.assertAll(
                        () -> {Assertions.assertEquals(120, counts.get(6));},
                        () -> {
                            Assertions.assertFalse(IntStream.range(0, 6).mapToObj(counts::get).filter(Objects::nonNull).findFirst().isPresent());
                        }
                );
                break;
            default:
                Assertions.fail("there is a test missing for some modes");

        }

    }
}
