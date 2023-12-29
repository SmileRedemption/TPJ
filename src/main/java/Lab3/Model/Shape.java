package Lab3.Model;


import java.io.Serializable;


public abstract class Shape implements Drawable, Serializable {
    private final String shapeColor;
    private double area;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calculateArea();

    @Override
    public String toString() {
        return "Shape{" +
                "shapeColor='" + shapeColor + '\'' +
                ", area=" + area +
                '}';
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
