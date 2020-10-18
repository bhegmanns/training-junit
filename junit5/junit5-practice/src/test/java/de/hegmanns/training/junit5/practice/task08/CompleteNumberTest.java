package de.hegmanns.training.junit5.practice.task08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CompleteNumberTest {

   int number = 0;

   @Test
   public void smoke() {
       Assertions.assertTrue(number>=0);
   }

//   @Test
//   public void three() {
//       number++;
//       Assertions.assertEquals(3, number);
//   }
//
//   @Test
//   public void two() {
//       number++;
//       Assertions.assertEquals(2, number);
//   }
//
//   @Test
//   public void four() {
//       number++;
//       Assertions.assertEquals(4,number);
//   }
//
//   @Test
//   public void one() {
//       number++;
//       Assertions.assertEquals(1, number);
//   }
}
