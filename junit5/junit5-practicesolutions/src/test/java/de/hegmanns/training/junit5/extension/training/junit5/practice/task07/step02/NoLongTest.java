package de.hegmanns.training.junit5.extension.training.junit5.practice.task07.step02;

import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@EnabledOnJre(JRE.JAVA_11)
@ExtendWith(NoLongTestCondition.class)
public @interface NoLongTest {
}
