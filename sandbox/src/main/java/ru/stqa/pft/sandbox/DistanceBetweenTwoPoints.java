package ru.stqa.pft.sandbox;

public class DistanceBetweenTwoPoints {
  public static void main(String[] args) {
    Point p1 = new Point(9, 7);
    Point p2 = new Point(3, 2);
    System.out.println("The distance between points " + "a (x1 = " + p1.x + ", y1 = " + p1.y + ") and " + "b (x2 = " + p2.x + ", y2 = " + p2.y + ") equals " + p1.distance(p2));
  }
}
