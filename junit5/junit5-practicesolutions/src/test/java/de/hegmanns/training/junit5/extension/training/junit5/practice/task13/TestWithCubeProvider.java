package de.hegmanns.training.junit5.extension.training.junit5.practice.task13;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(CubeTestTemplateProvider.class)
@TestTemplate
public @interface TestWithCubeProvider {
}
