package de.hegmanns.training.junit5.extension.training.junit5.practice.task06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice.task06.Cube;

import java.util.stream.IntStream;

public class FairCubeTest {

    private Cube cube;

    @BeforeEach
    public void prepareCube() {
        cube = new Cube();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @Disabled("please enable for demonstration")
    public void numberOk(int number) {
        Assertions.assertTrue(10 < IntStream.range(0, 120).map((i) -> cube.getNext()).filter((i) -> i==number).count());
    }
}
