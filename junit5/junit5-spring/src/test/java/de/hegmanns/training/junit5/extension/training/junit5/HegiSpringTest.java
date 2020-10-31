package de.hegmanns.training.junit5.extension.training.junit5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { HegiSpringApplication.class })
public class HegiSpringTest {

    @Autowired
    public HegiComponent hegiComponent;

    @Test
    public void test() {
        MatcherAssert.assertThat(hegiComponent.getCommonGreet(), Matchers.is("Hello anyone"));
    }
}
