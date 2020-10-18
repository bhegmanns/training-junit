package de.hegmanns.training.junit.special.template;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HegiTemplateTest {

    public NumberCheck numberCheck;

    @BeforeEach
    public void beforeAll() {
        numberCheck = new NumberCheck();
    }

    @TestTemplate
    @ExtendWith(HegiTestProvider.class)
    void theTestForTemplate(int number) {
        Assertions.assertTrue(numberCheck.isPreferred(number));
    }


    static class HegiTestProvider implements TestTemplateInvocationContextProvider{

        @Override
        public boolean supportsTestTemplate(ExtensionContext extensionContext) {
            return true;
        }

        /**
         * This method created the parameter-instance which is inserted in test-method
         * @param extensionContext
         * @return
         */
        @Override
        public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
            return IntStream.of(3, 11, 111).mapToObj((i) -> create(i));
        }

        private TestTemplateInvocationContext create(int number) {
            return new TestTemplateInvocationContext() {
                @Override
                public String getDisplayName(int invocationIndex) {
                    return "" + invocationIndex + " should be preferred when numberCheck preferred odd numbers";
                }

                @Override
                public List<Extension> getAdditionalExtensions() {
                    return Arrays.asList(

                    new ParameterResolver() {
                                @Override
                                public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
                                    return true;
                                }

                                @Override
                                public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
                                    HegiTemplateTest test = (HegiTemplateTest) extensionContext.getTestInstance().get();
                                    test.numberCheck.setOddAsPreferred(true);
                                    return number;
                                }
                            }
                    );
                }
            };

        }
    }
}
