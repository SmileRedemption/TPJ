package Lab3;

import Lab3.Model.Shape;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeShape {
    public static void serialize(Shape[] shapes){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("shapes.dat")))
        {
            objectOutputStream.writeObject(shapes);
            System.out.println("File has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Shape[] deserialize(String fileName){
        Shape[] newShapes = null;

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName)))
        {
            newShapes=(Shape[])objectInputStream.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        return newShapes;
    }
}
