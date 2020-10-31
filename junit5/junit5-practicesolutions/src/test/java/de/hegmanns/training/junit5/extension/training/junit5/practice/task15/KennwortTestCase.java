package de.hegmanns.training.junit5.extension.training.junit5.practice.task15;

public class KennwortTestCase {

    private String kennwort;
    private boolean gutesKennwort;
    private String testcaseBeschreibung;

    public KennwortTestCase(String kennwort, boolean gutesKennwort, String testcaseBeschreibung) {
        this.kennwort = kennwort;
        this.gutesKennwort = gutesKennwort;
        this.testcaseBeschreibung = testcaseBeschreibung;
    }

    public String getKennwort() {
        return kennwort;
    }

    public String getTestcaseBeschreibung() {
        return testcaseBeschreibung;
    }

    public boolean isGutesKennwort() {
        return gutesKennwort;
    }
}
