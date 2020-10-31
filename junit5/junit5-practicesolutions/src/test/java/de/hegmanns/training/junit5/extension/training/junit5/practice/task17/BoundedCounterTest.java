package de.hegmanns.training.junit5.extension.training.junit5.practice.task17;


import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import practice.task17.BoundedCounter;
import practice.task17.ValueHolder;

@ExtendWith(MockitoExtension.class)
public class BoundedCounterTest {

    @Mock
    ValueHolder valueHolder;

    @InjectMocks
    BoundedCounter boundedCounter;// = new BoundedCounter(valueHolder);

    @Test
    public void boundedCounterDoesntIncrementAboveMaximum() {
        int initialValue = 10;
        BoundedCounter counter = new BoundedCounter(initialValue, 0, 20);

        for (int i = 0; i < 100; i++) {
            counter.increment();
        }
        Assertions.assertEquals(20, counter.getValue());
    }

//    @Test
//    public void boundedCounterCheckWithIteration() {
//        BoundedCounter counter = new BoundedCounter(10, 0, 20);
//
//        // soll: Counter ist nun an oberer Grenze
//        ValueHolder valueHolder = Mockito.mock(ValueHolder.class);
//        Mockito.when(valueHolder.getValue()).thenReturn(20);
//        counter.setValueHolder(valueHolder);
//
//        counter.increment();
//        Mockito.verify(valueHolder, Mockito.never()).setValue(Mockito.anyInt());
////        Assertions.assertEquals(20, counter.getValue());
//    }

    @Test
    public void boundedCounterWithInject() {
        Mockito.when(valueHolder.getValue()).thenReturn(20);

        boundedCounter.increment();
        Mockito.verify(valueHolder, Mockito.never()).setValue(Mockito.anyInt());
    }

}
