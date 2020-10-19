package de.hegmanns.training.junit5.practice.task06;

import org.junit.jupiter.api.extension.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CubeTestTemplateProvider implements TestTemplateInvocationContextProvider {
    @Override
    public boolean supportsTestTemplate(ExtensionContext extensionContext) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
        return Stream.of(true, false).map((b) -> create(b));
    }

    private TestTemplateInvocationContext create(boolean fair){
        return new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return "for " + (fair?"fair":"unfair") + " cube";
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return Arrays.asList(new ParameterResolver() {
                    @Override
                    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
//                        return parameterContext.getParameter().getType().equals(CubeTestCase.class);
                        return true;
                    }

                    @Override
                    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                        return new CubeTestCase(new Cube(fair?CubeMode.FAIR:CubeMode.UNFAIR), fair?null:6);
                    }
                });
            }
        };
    }
}
