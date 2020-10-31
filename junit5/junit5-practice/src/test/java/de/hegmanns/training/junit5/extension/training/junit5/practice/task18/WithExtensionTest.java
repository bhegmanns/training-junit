package de.hegmanns.training.junit5.extension.training.junit5.practice.task18;

import org.junit.jupiter.api.Test;

public class WithExtensionTest {

    @Test
    public void foo01() {
        System.out.println("hello");
    }

    @Test
    public void foo02() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void foo03() {
        System.out.println("do anything :)");
    }
}
