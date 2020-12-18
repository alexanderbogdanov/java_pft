package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime() {
//    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    Assert.assertTrue(Primes.isPrime(23));
  }

  @Test
  public void testPrimeWhile() {
//    Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));
    Assert.assertTrue(Primes.isPrimeWhile(23));
  }

  @Test
  public void testPrimeFalse() {

//    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
    Assert.assertFalse(Primes.isPrimeWhile(10));
  }

  @Test
  public void testPrimeWhileFalse() {

//    Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE - 2));
    Assert.assertFalse(Primes.isPrimeWhile(10));
  }

  @Test(enabled = false)
  public void testPrimeLong() {
    long n =Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test
  public void testPrimeFast() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }


}
