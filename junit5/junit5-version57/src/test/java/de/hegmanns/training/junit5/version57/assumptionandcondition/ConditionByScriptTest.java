package de.hegmanns.training.junit5.version57.assumptionandcondition;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.condition.EnabledIf;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ConditionByScriptTest {



    @Disabled
    @DisplayName("Java Nashorn script Test")
    @Test
    void nashornTest(TestInfo testinfo) {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            // remove @Disabled to Demonstrating how nashorn script works
            Object result1 = engine.eval("2 * 3 == 6");

            System.out.println("(2 * 3 == 6) => "+result1);

            Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
            bindings.put("systemProperty", System.getProperties());
            bindings.put("junitDisplayName", testinfo.getDisplayName());
            bindings.put("junitTags", testinfo.getTags());
            engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);

            System.out.println("systemProperty.get('os.arch')) => "+engine.eval("systemProperty.get('os.arch')"));
            System.out.println("junitDisplayName => "+engine.eval("junitDisplayName"));
            System.out.println("junitTags => "+engine.eval("junitTags"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @EnabledIf("de.hegmanns.training.junit5.version57.assumptionandcondition.ConditionByScriptTest#wouldProceed()")
    // only method and only method without params
    public void proceeded() {

    }

    public boolean wouldProceed() {

        return true;
    }


}
