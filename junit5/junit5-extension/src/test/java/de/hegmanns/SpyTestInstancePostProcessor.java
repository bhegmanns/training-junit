package de.hegmanns;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.jupiter.engine.config.JupiterConfiguration;

import java.util.Optional;
import java.util.logging.Logger;

public class SpyTestInstancePostProcessor implements TestInstancePostProcessor {

    private static final Logger LOGGER = Logger.getLogger(SpyTestInstancePostProcessor.class.getName());

    public SpyTestInstancePostProcessor() {
        LOGGER.info("call SpyTestInstancePostProcessor-constructor" + System.currentTimeMillis());

    }

    @Override
    public void postProcessTestInstance(Object o, ExtensionContext extensionContext) throws Exception {

        LOGGER.info("call postProcessTestInstance " + o.getClass() + System.currentTimeMillis());
        Optional<String> configurationForBlaBlaBla = extensionContext.getConfigurationParameter("bla.bla.bla");
        configurationForBlaBlaBla.ifPresent((s) -> LOGGER.info("bla.bla.bla = " + s));

        Optional<String> property_name = extensionContext.getConfigurationParameter(JupiterConfiguration.DEFAULT_EXECUTION_MODE_PROPERTY_NAME);
        System.out.println("property_name = " + property_name.orElse("not set"));
    }
}
