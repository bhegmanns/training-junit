package de.hegmanns.training.junit.special.template;

import org.junit.jupiter.api.extension.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NumberCheckTestCaseProvider implements TestTemplateInvocationContextProvider {
    @Override
    public boolean supportsTestTemplate(ExtensionContext extensionContext) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
        return Stream.of(
                create(true, 5, true),
                create(true, 120, false),
                create(false, 5, false)
        );
    }

    private TestTemplateInvocationContext create(boolean isOddPreferred, int number, boolean isPreferred) {
        TestTemplateInvocationContext context = new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return "for " + (isOddPreferred?"odd preferred NumberCheck":"even preferred NumberCheck") + ", number " + number + " should be " + (isPreferred?"":"not") + " preferred";
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return Arrays.asList(
                        new ParameterResolver() {
                            @Override
                            public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return true;
                            }

                            @Override
                            public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return new NumberCheckTestCase(isOddPreferred, number, isPreferred);
                            }
                        }
                );
            }
        };
        return context;
    }
}
