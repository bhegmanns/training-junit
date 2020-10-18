package de.hegmanns.training.junit5.asserts.hamcrest;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.text.CharSequenceLength;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class HamcrestExamplesTest {

    @Test
    public void forSimpleValue() {
        int aSimpleInt = 6;

        MatcherAssert.assertThat(aSimpleInt, Matchers.is(6));
        MatcherAssert.assertThat(aSimpleInt, Matchers.lessThan(10));
        MatcherAssert.assertThat(aSimpleInt, Matchers.lessThanOrEqualTo(10));
        MatcherAssert.assertThat(aSimpleInt, Matchers.greaterThan(0));
        MatcherAssert.assertThat(aSimpleInt, Matchers.greaterThanOrEqualTo(0));
    }

    @Test
    public void forString() {
        String aSimpleString = "anyString";
        String aNullString = null;
        String anEmptyString = "";
        String stringOnlyWhitespaces = "   ";
        String stringWithWhitespaces = " any String ";

        MatcherAssert.assertThat(aSimpleString, Matchers.hasLength(9));
        MatcherAssert.assertThat(aSimpleString, Matchers.is("anyString"));
        MatcherAssert.assertThat(aSimpleString, Matchers.is("any" + "String"));
        MatcherAssert.assertThat(aSimpleString, Matchers.equalTo("anyString"));
        MatcherAssert.assertThat(aSimpleString, Matchers.equalTo("any" + "String"));
        MatcherAssert.assertThat(aSimpleString, Matchers.equalToIgnoringCase("anystring"));
        MatcherAssert.assertThat(aSimpleString, Matchers.equalToIgnoringCase("ANYSTRING"));

        MatcherAssert.assertThat(aSimpleString, Matchers.equalToIgnoringCase("any" + "String"));
        MatcherAssert.assertThat(aSimpleString, Matchers.isA(String.class));

        MatcherAssert.assertThat(anEmptyString, Matchers.isEmptyString());
        MatcherAssert.assertThat(anEmptyString, Matchers.blankString());

        MatcherAssert.assertThat(aNullString, Matchers.isEmptyOrNullString());
        MatcherAssert.assertThat(aNullString, Matchers.blankOrNullString());

        MatcherAssert.assertThat(anEmptyString, Matchers.isEmptyOrNullString());
        MatcherAssert.assertThat(anEmptyString, Matchers.blankOrNullString());

        MatcherAssert.assertThat(aSimpleString, Matchers.not(Matchers.isEmptyOrNullString()));
        MatcherAssert.assertThat(aSimpleString, Matchers.not(Matchers.blankOrNullString()));

        MatcherAssert.assertThat(aSimpleString, Matchers.startsWith("any"));
        MatcherAssert.assertThat(aSimpleString, Matchers.endsWith("ing"));

        MatcherAssert.assertThat(aSimpleString, Matchers.hasLength(9));

        MatcherAssert.assertThat(aSimpleString, CharSequenceLength.hasLength(Matchers.lessThan(20)));
        MatcherAssert.assertThat(aSimpleString, CharSequenceLength.hasLength(Matchers.greaterThan(5)));
    }

    @Test
    public void forBigDecimal() {
        BigDecimal anyBigDecimal = new BigDecimal("1.5");
        BigDecimal anyOtherBigDecimal = new BigDecimal(BigInteger.valueOf(1500), 3);

//        MatcherAssert.assertThat(anyBigDecimal, Matchers.equalTo(anyOtherBigDecimal));
//        MatcherAssert.assertThat(anyBigDecimal, Matchers.is(anyOtherBigDecimal));

        MatcherAssert.assertThat(anyBigDecimal, Matchers.not(Matchers.equalTo(anyOtherBigDecimal)));
        MatcherAssert.assertThat(anyBigDecimal, Matchers.comparesEqualTo(anyOtherBigDecimal));
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
        MatcherAssert.assertThat(aSimpleString, Matchers.notNullValue());
        MatcherAssert.assertThat(aNullString, Matchers.nullValue());
        MatcherAssert.assertThat(aSimpleString, Matchers.sameInstance(aSimpleString));
        MatcherAssert.assertThat(aSimpleString, Matchers.not(Matchers.sameInstance(firstPart + secondPart)));

    }

    @Test
    public void forCollections() {
        List<String> stringList = Arrays.asList("any", "String", "to", "put", "in", "the", "set");
        Set<String> stringSet = new HashSet<>(stringList);
        Set<String> emptySet = new HashSet<>();

        MatcherAssert.assertThat(stringSet, Matchers.hasSize(7));
        MatcherAssert.assertThat(stringList, Matchers.contains("any", "String", "to", "put", "in", "the", "set"));
        MatcherAssert.assertThat(stringList, Matchers.not(Matchers.contains("String", "any", "to", "put", "in", "the", "set"))); // wrong order
        MatcherAssert.assertThat(stringList, Matchers.containsInAnyOrder("String", "any", "to", "put", "in", "the", "set"));
        MatcherAssert.assertThat(stringSet, Matchers.containsInAnyOrder("String", "any", "to", "put", "in", "the", "set"));

        MatcherAssert.assertThat(stringList, Matchers.containsInRelativeOrder("String", "the", "set"));
        MatcherAssert.assertThat(stringList, Matchers.hasItem("to"));
        MatcherAssert.assertThat(stringList, Matchers.hasItems("put", "set"));

        MatcherAssert.assertThat(emptySet, Matchers.empty());
        MatcherAssert.assertThat(emptySet, Matchers.emptyCollectionOf(String.class));

        MatcherAssert.assertThat(stringSet, Matchers.iterableWithSize(7));
        MatcherAssert.assertThat(stringSet, Matchers.not(Matchers.hasItem(CharSequenceLength.hasLength(Matchers.greaterThan(10)))));
        MatcherAssert.assertThat(stringSet, Matchers.not(Matchers.hasItem(CharSequenceLength.hasLength(Matchers.lessThan(2)))));
    }


    @Test
    public void forMaps() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Willi", 60);
        ages.put("Else", 58);
        ages.put("Stefan", 20);
        ages.put("Emili", 18);
        ages.put("Daniel", 19);

        MatcherAssert.assertThat(ages, Matchers.aMapWithSize(5));
        MatcherAssert.assertThat(ages, Matchers.not(Matchers.anEmptyMap()));
        MatcherAssert.assertThat(ages, Matchers.hasEntry("Stefan", 20));
        MatcherAssert.assertThat(ages, Matchers.hasEntry(Matchers.any(String.class), Matchers.greaterThan(20)));
    }

    @Test
    public void forArrays() {
        String[] strings = {"any", "String", "to", "put", "in", "the", "array"};

        MatcherAssert.assertThat(strings, Matchers.arrayWithSize(7));
        MatcherAssert.assertThat(strings, Matchers.not(Matchers.arrayContainingInAnyOrder("the", "to")));
        MatcherAssert.assertThat(strings, Matchers.hasItemInArray("the"));

        MatcherAssert.assertThat(strings, Matchers.hasItemInArray("the"));
    }

    @Test
    public void everytime() {
        MatcherAssert.assertThat(null, Matchers.anything());
        MatcherAssert.assertThat(null, Matchers.anything("..."));
    }
}