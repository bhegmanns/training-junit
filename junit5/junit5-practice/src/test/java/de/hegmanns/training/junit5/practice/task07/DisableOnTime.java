package de.hegmanns.training.junit5.practice.task07;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DisableOnTime {
    public String from() default "00:00";
    public String until() default "24:00";
}
