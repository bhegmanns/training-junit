package de.hegmanns.training.junit5.extension.training.junit5.template;

import org.junit.jupiter.api.extension.*;

import java.util.*;
import java.util.stream.Stream;

public class TaskPossibleActionTestCaseProvider implements TestTemplateInvocationContextProvider {
    @Override
    public boolean supportsTestTemplate(ExtensionContext extensionContext) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
        // it should be a good idea make a matrix

        List<TestTemplateInvocationContext> result = new ArrayList<>();
        for (TaskState state : TaskState.values()) {
            for (TaskAction action : TaskAction.values()) {
                result.add(create(state, action));
            }
        }

        return result.stream();
    }

    private TestTemplateInvocationContext create(TaskState taskState, TaskAction taskAction) {
        TestTemplateInvocationContext context = new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return "for " + taskState + " in Action " + taskAction;
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return Arrays.asList(
                        // for testmethods: signature foo(TaskForActionTestCase testCase)
                        new ParameterResolver() {
                            @Override
                            public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return parameterContext.getParameter().getType().equals(TaskForActionTestCase.class);
                            }

                            @Override
                            public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return new TaskForActionTestCase(taskAction, taskState);
                            }
                        },

                        // the following resolvers are for testmethods: signature foo(TaskState taskState, TaskAction taskAction)
                        new ParameterResolver() {
                            @Override
                            public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return extensionContext.getTestMethod().get().getParameterCount()==2
                                && parameterContext.getIndex()==0;// sehr banal formuliert
                            }

                            @Override
                            public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return taskState;
                            }
                        },
                        new ParameterResolver() {
                            @Override
                            public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return extensionContext.getTestMethod().get().getParameterCount()==2
                                        && parameterContext.getIndex()==1;// sehr banal formuliert
                            }

                            @Override
                            public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return taskAction;
                            }
                        }
                );
            }
        };
        return context;
    }
}
