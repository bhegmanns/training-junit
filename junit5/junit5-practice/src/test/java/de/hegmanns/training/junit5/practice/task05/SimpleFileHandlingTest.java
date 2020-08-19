package de.hegmanns.training.junit5.practice.task05;

import org.junit.jupiter.api.Test;

public class SimpleFileHandlingTest extends AbstractFileHandlingTest{


    public SimpleFileHandlingTest() {
        super("");
    }

    @Test
    public void fileFillerCreatesNewFileByFilling() {
        FileFiller fileFiller = new FileFiller(getFilePath());

        fileFiller.writeLine("One line");

        // and so on
    }
}

