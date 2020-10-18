package de.hegmanns.training.junit5.asserts.hamcrest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HamcrestExamplesWithStaticImportTest {

    @Test
    public void forSimpleValue() {
        int aSimpleInt = 6;

        assertThat(aSimpleInt, is(6));
        assertThat(aSimpleInt, lessThan(10));
        assertThat(aSimpleInt, lessThanOrEqualTo(10));
        assertThat(aSimpleInt, greaterThan(0));
        assertThat(aSimpleInt, greaterThanOrEqualTo(0));
    }

    @Test
    public void forString() {
        String aSimpleString = "anyString";
        String aNullString = null;
        String anEmptyString = "";
        String stringOnlyWhitespaces = "   ";
        String stringWithWhitespaces = " any String ";

        assertThat(aSimpleString, hasLength(9));
        assertThat(aSimpleString, is("anyString"));
        assertThat(aSimpleString, is("any" + "String"));
        assertThat(aSimpleString, equalTo("anyString"));
        assertThat(aSimpleString, equalTo("any" + "String"));
        assertThat(aSimpleString, equalToIgnoringCase("anystring"));
        assertThat(aSimpleString, equalToIgnoringCase("ANYSTRING"));

        assertThat(aSimpleString, equalToIgnoringCase("any" + "String"));
        assertThat(aSimpleString, isA(String.class));
        assertThat(anEmptyString, isEmptyString());
        assertThat(aNullString, isEmptyOrNullString());
        assertThat(anEmptyString, isEmptyOrNullString());
        assertThat(aSimpleString, not(isEmptyOrNullString()));

        assertThat(aSimpleString, startsWith("any"));
        assertThat(aSimpleString, endsWith("ing"));


    }

    @Test
    public void forBigDecimal() {
        BigDecimal anyBigDecimal = new BigDecimal("1.5");
        BigDecimal anyOtherBigDecimal = new BigDecimal(BigInteger.valueOf(1500), 3);

//        MatcherAssert.assertThat(anyBigDecimal, equalTo(anyOtherBigDecimal));
//        MatcherAssert.assertThat(anyBigDecimal, is(anyOtherBigDecimal));

        assertThat(anyBigDecimal, not(equalTo(anyOtherBigDecimal)));
        assertThat(anyBigDecimal, comparesEqualTo(anyOtherBigDecimal));
    }

    @Test
    public void forObjects() {
        String aSimpleString = "anyString";
        String aNullString = null;
        String anEmptyString = "";
        String stringOnlyWhitespaces = "   ";
        String stringWithWhitespaces = " any String ";

        String firstPart = "any";
        String secondPart = "String";
        assertThat(aSimpleString, notNullValue());
        assertThat(aNullString, nullValue());
        assertThat(aSimpleString, sameInstance(aSimpleString));
        assertThat(aSimpleString, not(sameInstance(firstPart + secondPart)));

    }

    @Test
    public void forCollections() {
        List<String> stringList = Arrays.asList("any", "String", "to", "put", "in", "the", "set");
        Set<String> stringSet = new HashSet<>(stringList);
        Set<String> emptySet = new HashSet<>();

        assertThat(stringSet, hasSize(7));
        assertThat(stringList, contains("any", "String", "to", "put", "in", "the", "set"));
        assertThat(stringList, not(contains("String", "any", "to", "put", "in", "the", "set")));
        assertThat(stringList, containsInAnyOrder("String", "any", "to", "put", "in", "the", "set"));
        assertThat(stringSet, containsInAnyOrder("String", "any", "to", "put", "in", "the", "set"));

        assertThat(stringList, hasItem("to"));
        assertThat(stringList, hasItems("put", "set"));

        assertThat(emptySet, empty());
        assertThat(emptySet, emptyCollectionOf(String.class));

        assertThat(stringSet, iterableWithSize(7));
    }

    @Test
    public void forMaps() {

    }

    @Test
    public void forArrays() {
        String[] strings = {"any", "String", "to", "put", "in", "the", "array"};

        assertThat(strings, arrayWithSize(7));
        assertThat(strings, not(arrayContainingInAnyOrder("the", "to")));
        assertThat(strings, hasItemInArray("the"));

        assertThat(strings, hasItemInArray("the"));
    }

    @Test
    public void everytime() {
        assertThat(null, anything());
        assertThat(null, anything("..."));
    }
}
