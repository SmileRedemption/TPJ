package Lab3.Model;

public class Circle extends Shape {
    private final double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
        setArea(calculateArea());
    }

    @Override
    public void draw() {
        System.out.println("I draw a " + getShapeColor() + " circle. Radius = " + radius + " Area = " + getArea());
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
