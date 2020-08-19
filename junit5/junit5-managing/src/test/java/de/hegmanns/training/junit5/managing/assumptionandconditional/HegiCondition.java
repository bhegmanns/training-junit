package de.hegmanns.training.junit5.managing.assumptionandconditional;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(HegiSampleTestCondition.class)
public @interface HegiCondition {
    String info() default "";
}
