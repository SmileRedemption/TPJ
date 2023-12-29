package Lab3.Model;

import java.util.Arrays;

public class Rectangle extends Shape{
    private final int[] lengthsOfTwoSides;

    public Rectangle(String shapeColor, int[] lengthsOfTwoSides) {
        super(shapeColor);
        this.lengthsOfTwoSides = lengthsOfTwoSides;
        setArea(calculateArea());
    }

    @Override
    public void draw() {
        System.out.println("I draw a " + getShapeColor() +  " rectangle. With length = " + Arrays.toString(lengthsOfTwoSides) + " Area = " + getArea());
    }

    @Override
    public double calculateArea() {
        return lengthsOfTwoSides[0] * lengthsOfTwoSides[1];
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "lengthsOfSides=" + Arrays.toString(lengthsOfTwoSides) +
                '}';
    }
}
