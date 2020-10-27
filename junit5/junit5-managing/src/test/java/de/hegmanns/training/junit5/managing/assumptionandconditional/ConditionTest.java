package de.hegmanns.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class ConditionTest {


    @Disabled
    @Test
    void printSystemProperties() {
        //remove @Disabled to see System properties
        System.getProperties().forEach((key, value) -> System.out.println(key+" - "+value));
    }
    @Test
    @EnabledIfSystemProperty(named = "java.vm.vendor", matches = "Oracle.*")
    void runOnlyOnOracleJDK() {
        System.out.println("Run this only on Oracle JDK");
    }
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
    void runOnlyOn32bitOS() {
        System.out.println("Run this on only on 32 bit OS");
    }

    @Test
    @DisabledIfSystemProperty(named = "os.version", matches = ".*10.*")
    void notRunOnlyOnWindows10() {
        System.out.println("not run this only on windows 10 version");
    }

    @Test
    @EnabledIfSystemProperty(named = "os.version", matches = ".*10.*")
    void runOnlyOnWindows10() {
        System.out.println("Run this only on WINDOWS OS 10 version");

        System.getProperties().entrySet().stream().forEach((e) -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    @Test
    @EnabledIfSystemProperty(named="user.language", matches = "de")
    void runOnlyForGermanLanguages() {
        System.out.println("Nur in deutscher Sprache");
    }

    @Test
    @EnabledIfSystemProperty(named="user.language", matches = "!(de)")
    void runNotForGermanLanguages() {
        System.out.println("Every language but german");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "env", matches = "prelive")
    void runForPrelive() {
        System.out.println("Running vor Pre-Live");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "env", matches = "hudson")
    void runForBuildserver() {
        System.out.println("Running vor Build-Server");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "env", matches = "DEV")
    void runForDevelopment() {
        System.out.println("Running vor Development");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "env", matches = "test")
    void runForTest() {
        System.out.println("Running vor test");
    }



//    @Test
//    @EnabledIf("2 * 3 == 6")
//    void runOnlyIfExpressionValueTrue() {
//        System.out.println("(2 * 3 == 6) => true");
//    }
//
//    // Regular expression testing bound system property.
//    @Test
//    @DisabledIf("/32/.test(systemProperty.get('os.arch'))")
//    void notRunOn32bitOS() {
//        System.out.println("Not run this on 32 bit OS");
//    }
//
//    @Test
//    @EnabledIf("'admin' == systemEnvironment.get('USERNAME')")
//    void runOnlyForSpecificUser() {
//        System.out.println("Run this only for specific user");
//    }
//
//    // Multi-line script, can give custom engine name and custom reason.
//    @Test
//    @EnabledIf(value = {
//            "load('classpath:script/myScript.js')",
//            "",
//            "myfunction(10) == true"
//    },
//            engine = "javascript",
//            reason = "On {annotation}, with script: {script}, result is: {result}\"")
//    void runOnlyOnlyIfValueIsEven() {
//        System.out.println("Run this only for Even numbers");
//    }
}
