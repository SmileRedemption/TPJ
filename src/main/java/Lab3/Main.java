package Lab3;

import Lab3.Controller.Controller;
import Lab3.Model.Shape;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.show();
        controller.calculateSumOfArea();

        System.out.println();

        controller.calculateAreaOfCircle();
        controller.calculateAreaOfTriangle();
        controller.calculateAreaOfRectangle();

        System.out.println();

        controller.sortByArea();
        controller.show();

        System.out.println();

        controller.sortByShapeColor();
        controller.show();

        System.out.println("Lab 5: ");
        SerializeShape.serialize(controller.getShapes());
        Shape[] newShapes = SerializeShape.deserialize("shapes.dat");

        System.out.println("Data from file: ");
        for (Shape newShape : newShapes) {
            System.out.println(newShape);
        }
    }
}
