package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Square s = new Square(5);
        Rectangle r = new Rectangle(5, 8);
        System.out.println("Square area with a side " + s.l + " = " + s.area());
        System.out.println("Rectangle area with side " + r.a + " and " + r.b + " = " + r.area());

        //Вычисление расстояния меду двумя точками при помощи функции
        Point p1 = new Point(9, 7);
        Point p2 = new Point(3, 2);
        System.out.println("The distance between points " +
                "a (x1 = " + p1.x + ", y1 = " + p1.y + ") and " +
                "b (x2 = " + p2.x + ", y2 = " + p2.y + ") equals " + (distance(p1, p2)));
    }

    public static double distance(Point p1, Point p2) {
        double result = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        return Math.round(result * 100.0) / 100.0;
    }

}
