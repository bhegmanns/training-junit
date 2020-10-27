package de.hegmanns.training.junit5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.Annotation;

@ComponentScan
public class HegiSpringApplication {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                HegiSpringApplication.class)) {
            HegiComponent hegiComponent = context
                    .getBean(HegiComponent.class);
            System.out.println(hegiComponent.getCommonGreet());
        }
    }
}
