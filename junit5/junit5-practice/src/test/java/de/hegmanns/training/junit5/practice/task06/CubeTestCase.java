package de.hegmanns.training.junit5.practice.task06;

import java.util.Optional;

public class CubeTestCase {

    private Cube cube;
    private Integer expectedNumber;

    public CubeTestCase(Cube cube) {
        this(cube, null);
    }

    public CubeTestCase(Cube cube, Integer expectedNumber) {
        this.cube = cube;
        this.expectedNumber = expectedNumber;
    }

    public Cube getCube() {
        return cube;
    }

    public Optional<Integer> getExpected() {
        return Optional.ofNullable(expectedNumber);
    }
}
