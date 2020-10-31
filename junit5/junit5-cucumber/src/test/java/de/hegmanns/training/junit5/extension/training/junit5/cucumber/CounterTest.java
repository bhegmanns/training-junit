package de.hegmanns.training.junit5.extension.training.junit5.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import java.util.stream.IntStream;

public class CounterTest {

    private Counter counter;

    @Given("^a calculator created")
    public void forSetup() {
        counter = new Counter(10);
    }

    @When("^do increment (\\d+) times$")
    public void doIncrement(int countIncrements) {
        IntStream.range(1, countIncrements).forEach((i) -> counter.doCommand("+"));
    }

    @Then("^result ist (\\d+)$")
    public void checkValue(int expected) {
        MatcherAssert.assertThat(counter.getValue(), Matchers.is(expected));
    }
}
