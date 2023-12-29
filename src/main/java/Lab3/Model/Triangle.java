package Lab3.Model;

import java.util.Arrays;

public class Triangle extends Shape{
    private final int[] lengthsOfSides;

    public Triangle(String shapeColor, int[] lengthsOfSides) {
        super(shapeColor);
        this.lengthsOfSides = lengthsOfSides;
        setArea(calculateArea());
    }

    @Override
    public void draw() {
        System.out.println("I draw a " + getShapeColor() + "Triangle. With length = " + Arrays.toString(lengthsOfSides) + " Area = " + getArea());
    }

    @Override
    public double calculateArea() {
        float halfPerimeter = (float) Arrays.stream(lengthsOfSides).sum() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - lengthsOfSides[0]) *(halfPerimeter - lengthsOfSides[1])*(halfPerimeter - lengthsOfSides[2]));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "lengthsOfSides=" + Arrays.toString(lengthsOfSides) +
                '}';
    }
}
