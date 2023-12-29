package Lab3.Controller;

import Lab3.Model.*;

import java.util.Arrays;
import java.util.Comparator;


public class Controller {
    private final Shape[] shapes;

    public Controller() {
        shapes = generateShape();
    }

    public void show(){
        for (var shape : shapes)
            shape.draw();
    }

    public void calculateSumOfArea(){
        double sumOfArea = 0;

        for (var shape : shapes) {
            sumOfArea += shape.getArea();
        }

        System.out.println("The sum of areas: " + sumOfArea);
    }

    public void calculateAreaOfCircle(){
        double sumOfArea = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle)
                sumOfArea += shape.getArea();
        }

        System.out.println("The sum of circles: " + sumOfArea);
    }

    public void calculateAreaOfTriangle(){
        double sumOfArea = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Triangle)
                sumOfArea += shape.getArea();
        }

        System.out.println("The sum of triangles: " + sumOfArea);
    }

    public void calculateAreaOfRectangle(){
        double sumOfArea = 0;

        for (Shape shape : shapes) {
            if (shape instanceof Rectangle)
                sumOfArea += shape.getArea();
        }

        System.out.println("The sum of rectangles: " + sumOfArea);
    }


    public void sortByArea(){
        Arrays.sort(shapes, Comparator.comparing(Shape::getArea));
    }

    public void sortByShapeColor(){
        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));
    }

    private Shape[] generateShape(){
        Shape blueCircle = new Circle("Blue",10);
        Shape greenCircle = new Circle("Green",5);
        Shape yellowCircle = new Circle("Yellow",2);
        Shape orangeCircle = new Circle("Orange",3.5);

        Shape pinkRectangle = new Rectangle("Pink", new int[]{2, 5});
        Shape blackRectangle = new Rectangle("Black", new int[]{5, 5});
        Shape darkRectangle = new Rectangle("Dark", new int[]{10, 8});

        Shape brownTriangle = new Triangle("Brown", new int[]{10, 8, 13});
        Shape redTriangle = new Triangle("Red", new int[]{3, 4, 5});
        Shape goldTriangle = new Triangle("Gold", new int[]{6, 8, 10});

        return new Shape[]{
                blueCircle, greenCircle, yellowCircle, orangeCircle,
                pinkRectangle, blackRectangle, darkRectangle,
                brownTriangle, redTriangle, goldTriangle
        };
    }

    public Shape[] getShapes() {
        return shapes;
    }
}
