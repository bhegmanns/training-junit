package de.hegmanns.training.junit5.asserts.assertj;

import de.hegmanns.training.junit5.asserts.customer.Customer;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.assertj.core.api.StringAssert;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.text.CharSequenceLength;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

public class AssertJExampleTest {

    @Test
    public void forSimpleValue() {
        int aSimpleInt = 6;

        Assertions.assertThat(aSimpleInt).isEqualTo(6);
        Assertions.assertThat(aSimpleInt).isLessThan(10);
        Assertions.assertThat(aSimpleInt).isLessThanOrEqualTo(10);
        Assertions.assertThat(aSimpleInt).isGreaterThan(0);
        Assertions.assertThat(aSimpleInt).isGreaterThanOrEqualTo(0);
    }

    @Test
    public void forString() {
        String aSimpleString = "anyString";
        String aNullString = null;
        String anEmptyString = "";
        String stringOnlyWhitespaces = "   ";
        String stringWithWhitespaces = " any String ";

        Assertions.assertThat(aSimpleString).hasSize(9);
        Assertions.assertThat(aSimpleString).isEqualTo("anyString");
        Assertions.assertThat(aSimpleString).isEqualTo("any" + "String");
        Assertions.assertThat(aSimpleString).containsIgnoringCase("ANYSTRING");
        Assertions.assertThat(anEmptyString).isEmpty();
        Assertions.assertThat(aNullString).isNull();
        Assertions.assertThat(stringOnlyWhitespaces).containsOnlyWhitespaces();
        Assertions.assertThat(stringWithWhitespaces).containsWhitespaces();
        Assertions.assertThat(aSimpleString).endsWith("ing");
        Assertions.assertThat(aSimpleString).startsWith("any");

        Assertions.assertThat(aSimpleString).isExactlyInstanceOf(String.class);
        Assertions.assertThat(aSimpleString).isInstanceOf(String.class);

        Assertions.assertThat(aSimpleString).hasSizeGreaterThan(5);
        Assertions.assertThat(aSimpleString).hasSizeLessThan(20);
        Assertions.assertThat(aSimpleString).hasSizeLessThan(20).hasSizeGreaterThan(5);
        Assertions.assertThat(aSimpleString).hasSizeBetween(5, 20);

    }

    @Test
    public void forBigDecimal() {
        BigDecimal anyBigDecimal = new BigDecimal("1.5");
        BigDecimal anyNegativeBigDecimal = new BigDecimal("-1.5");
        BigDecimal anyOtherBigDecimal = new BigDecimal(BigInteger.valueOf(1500), 3);

        Assertions.assertThat(anyBigDecimal).isPositive();
        Assertions.assertThat(anyNegativeBigDecimal).isNegative();
        Assertions.assertThat(anyBigDecimal).isEqualByComparingTo("1.5");
        Assertions.assertThat(anyOtherBigDecimal).isEqualByComparingTo("1.5");
        Assertions.assertThat(anyBigDecimal).isEqualByComparingTo(anyOtherBigDecimal);

        Assertions.assertThat(anyNegativeBigDecimal).isNotZero();
        Assertions.assertThat(BigDecimal.ZERO).isZero();
        Assertions.assertThat(anyNegativeBigDecimal).isLessThan(anyBigDecimal);
        Assertions.assertThat(BigDecimal.ZERO).isBetween(anyNegativeBigDecimal, anyBigDecimal);
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

        Assertions.assertThat(aSimpleString).isNotNull();
        Assertions.assertThat(aNullString).isNull();
        Assertions.assertThat(aSimpleString).hasSameClassAs(stringOnlyWhitespaces);
        Assertions.assertThat(aSimpleString).isSameAs(aSimpleString);
        Assertions.assertThat(aSimpleString).isNotSameAs(firstPart + secondPart);
    }

    @Test
    public void forCollections() {
        List<String> stringList = Arrays.asList("any", "String", "to", "put", "in", "the", "set");
        Set<String> stringSet = new HashSet<>(stringList);
        Set<String> emptySet = new HashSet<>();

        Assertions.assertThat(stringSet).hasSize(7);
        Assertions.assertThat(stringSet).hasSizeLessThan(10).hasSizeGreaterThan(2);
        Assertions.assertThat(stringSet).hasSizeBetween(2, 10);

        Assertions.assertThat(stringList).containsExactly("any", "String", "to", "put", "in", "the", "set");
        Assertions.assertThat(stringList).doesNotContain("not");
        Assertions.assertThat(stringList).doesNotContainNull();
        Assertions.assertThat(stringList).doesNotContainSequence("String", "any", "to", "put", "in", "the", "set");
        Assertions.assertThat(stringList).contains("String", "any", "to", "put", "in", "the", "set");



        Assertions.assertThat(stringList).contains("to");
        Assertions.assertThat(stringList).contains("put", "set");
        Assertions.assertThat(stringList).contains("set", "put");

        Assertions.assertThat(emptySet).isEmpty();
        Assertions.assertThat(stringList).hasOnlyElementsOfType(String.class);
        Assertions.assertThat(stringList).hasOnlyElementsOfType(String.class);
//        Assertions.assertThat(stringList).hasOnlyElementsOfType(Integer.class); //
        Assertions.assertThat(emptySet).hasOnlyElementsOfType(Integer.class).isEmpty(); // ...
    }


    @Test
    public void forMaps() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Willi", 60);
        ages.put("Else", 58);
        ages.put("Stefan", 20);
        ages.put("Emili", 18);
        ages.put("Daniel", 19);

        Assertions.assertThat(ages).hasSize(5);

        Assertions.assertThat(ages).containsEntry("Stefan", 20);
        Assertions.assertThat(ages).containsKey("Else");
        Assertions.assertThat(ages).containsValue(19);
        Assertions.assertThat(ages).containsOnlyKeys("Willi", "Else", "Stefan", "Emili", "Daniel");
    }

    @Test
    public void forArrays() {
        String[] strings = {"any", "String", "to", "put", "in", "the", "array"};

        Assertions.assertThat(strings).hasSize(7);

        Assertions.assertThat(strings).contains("the", "to");
        Assertions.assertThat(strings).contains("to", "the");
//        Assertions.assertThat(strings).contains("the", "to", "heroes");
        Assertions.assertThat(strings).doesNotContain("heroes");
        Assertions.assertThat(strings).containsExactly("any", "String", "to", "put", "in", "the", "array");
    }



}
