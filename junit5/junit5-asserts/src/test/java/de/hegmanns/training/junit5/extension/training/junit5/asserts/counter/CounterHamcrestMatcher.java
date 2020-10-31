package de.hegmanns.training.junit5.extension.training.junit5.asserts.counter;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import java.util.*;
import java.util.stream.Collectors;

public class CounterHamcrestMatcher extends TypeSafeMatcher<NumericCounter> {
    private enum CheckType {MIN, MAX, VALUE};


    private NumericCounter exampleCounter;
    private CheckType[] currentCheckTypes;
    private Map<CheckType, Boolean> checkResults;
    private Map<CheckType, Integer> exampleAttributes;
    private Map<CheckType, Integer> itemAttributes;

    public CounterHamcrestMatcher(NumericCounter counter) {
        this(counter, CheckType.MIN, CheckType.MAX, CheckType.VALUE);
    }

    public CounterHamcrestMatcher(NumericCounter counter, CheckType ... checkTypes){
        this.exampleCounter = counter;
        this.currentCheckTypes = checkTypes;
        checkResults = new HashMap<>(checkTypes.length);
        exampleAttributes = new HashMap<>(checkTypes.length);
        itemAttributes = new HashMap<>(checkTypes.length);
    }

    @Override
    protected boolean matchesSafely(NumericCounter item) {
        if (currentCheckTypes == null || currentCheckTypes.length == 0) {
            return false; // no checktype
        }

        if (item == null && exampleCounter == null) {
            return true; // both null
        }

        if (item != null && exampleCounter == null || item == null && exampleCounter != null) {
            return false; // one is null
        }

        List<CheckType> checkTypes = Arrays.asList(currentCheckTypes);
        if (checkTypes.contains(CheckType.VALUE)) {
            exampleAttributes.put(CheckType.VALUE, exampleCounter.getValue());
            itemAttributes.put(CheckType.VALUE, item.getValue());
            checkResults.put(CheckType.VALUE, item.getValue() == exampleCounter.getValue());
        }


        if (checkTypes.contains(CheckType.MIN)) {
            checkResults.put(CheckType.MIN, near(item).map(BoundedNumericCounter::getMinimalValue).map((b) -> exampleCounter != null && b == near(exampleCounter).get().getMinimalValue())
                    .orElse(false));
            near(exampleCounter).ifPresent((b) -> exampleAttributes.put(CheckType.MIN, b.getMinimalValue()));
            near(item).ifPresent((b) -> itemAttributes.put(CheckType.MIN, b.getMinimalValue()));
        }

        if (checkTypes.contains(CheckType.MAX)) {
            checkResults.put(CheckType.MAX, near(item).map(BoundedNumericCounter::getMaximumValue).map((b) -> exampleCounter != null && b == near(exampleCounter).get().getMaximumValue())
                    .orElse(false));
            near(exampleCounter).ifPresent((b) -> exampleAttributes.put(CheckType.MAX, b.getMaximumValue()));
            near(item).ifPresent((b) -> itemAttributes.put(CheckType.MAX, b.getMaximumValue()));
        }

        return checkResults.values().stream().filter((b) -> b == false).findFirst().orElse(true);
    }

    private Optional<BoundedNumericCounter> near(NumericCounter counter) {
        if (isBoundedCounter(counter)) {
            return Optional.of((BoundedNumericCounter) counter);
        }else{
            return Optional.empty();
        }
    }

    private boolean isBoundedCounter(NumericCounter numericCounter) {
        return numericCounter != null && numericCounter instanceof BoundedNumericCounter;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("matches to ");
        description.appendText(checkResults.keySet().stream().map((c) -> c.name() + ":" + itemAttributes.get(c)).collect(Collectors.joining(",")));
    }

    @Override
    protected void describeMismatchSafely(NumericCounter item, Description mismatchDescription) {
        String description = "";

        mismatchDescription.appendText(checkResults.entrySet().stream().filter((e) -> !e.getValue())
                .map((e) -> "" + e.getKey() + ":" + exampleAttributes.get(e.getKey()))
                .collect(Collectors.joining(",")));
    }

    public static CounterHamcrestMatcher matches(NumericCounter counter) {
        return new CounterHamcrestMatcher(counter);
    }

    public static CounterHamcrestMatcher sameValue(NumericCounter counter) {
        return new CounterHamcrestMatcher(counter, CheckType.VALUE);
    }

    public static CounterHamcrestMatcher sameMinimum(BoundedNumericCounter boundedNumericCounter) {
        return new CounterHamcrestMatcher(boundedNumericCounter, CheckType.MIN);
    }

    public static CounterHamcrestMatcher sameMaximum(BoundedNumericCounter boundedNumericCounter) {
        return new CounterHamcrestMatcher(boundedNumericCounter, CheckType.MAX);
    }
}
