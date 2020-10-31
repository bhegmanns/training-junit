package de.hegmanns.training.junit5.extension.training.junit5.practice.task08;

import org.junit.jupiter.api.MethodDescriptor;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrdererContext;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WrittenNumberOrderer implements MethodOrderer {
    private static Map<String, Integer> values = new HashMap<String, Integer>(){{put("one" , 1);
            put("two",2);
            put("three", 3);
            put("four", 4);
            put("fife",5);}};
    private static final Comparator<MethodDescriptor> comparator =
            Comparator.comparing((descriptor) -> {return parseToNumber(descriptor.getMethod().getName());})
            ;


    static int parseToNumber(String string) {
        return values.entrySet().stream()
                .filter((e) -> string.contains(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst().orElse(Integer.MAX_VALUE);
    }
    @Override
    public void orderMethods(MethodOrdererContext methodOrdererContext) {
        methodOrdererContext.getMethodDescriptors().sort(comparator);
    }


}
