package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test(description = "Positive method test")
  public void testMethodPositive() {
    Point p1 = new Point(9, 7);
    Point p2 = new Point(3, 2);
    Assert.assertEquals(p1.distance(p2), 7.81);
  }

  @Test(description = "Zero value test")
  public void testZeroValue() {
    Point p1 = new Point(9, 0);
    Point p2 = new Point(3, 2);
    Assert.assertEquals(p1.distance(p2),6.32);
  }

  @Test(description = "Negative value test")
  public void testNegativeValue() {
    Point p1 = new Point(9, -7);
    Point p2 = new Point(3, 2);
    Assert.assertEquals(p1.distance(p2),10.82);
  }

  @Test(description = "Rounding to 2 decimal digits test")
  public void testRounding() {
    Point p1 = new Point(9, 7);
    Point p2 = new Point(3, 2);
    Assert.assertNotEquals(p1.distance(p2),7.810249675906654);
  }
}
