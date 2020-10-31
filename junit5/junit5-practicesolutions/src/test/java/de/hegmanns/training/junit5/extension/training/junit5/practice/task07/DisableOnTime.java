package de.hegmanns.training.junit5.extension.training.junit5.practice.task07;

import de.hegmanns.training.junit5.extension.training.junit5.practice.task07.step01.DisableOnTimeCondition;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(DisableOnTimeCondition.class)
public @interface DisableOnTime {
    public String from() default "00:00";

    public String until() default "23:59";
}
