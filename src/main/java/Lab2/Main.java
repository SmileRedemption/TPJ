package Lab2;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Person person = new Person("Mike", 23, true);
        System.out.println("Before serialize: " + person);

        serializePerson(person);

        Person deserializePerson = deserializePerson("src/main/java/Lab2/person.json");
        System.out.println("After serialize: " + deserializePerson);


        System.out.println("This 2 objects are equals: " + person.equals(deserializePerson));
    }

    public static void serializePerson(Person person){
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);

        try (FileWriter writer = new FileWriter("src/main/java/Lab2/person.json")){
            writer.write(jsonPerson);
        }
        catch (IOException e) {
        System.out.println(e.getMessage());
        }
    }

    public static Person deserializePerson(String pathOfFileForDeserialization){
        Gson gson = new Gson();

        try(FileReader reader = new FileReader(pathOfFileForDeserialization)) {
            return gson.fromJson(reader, Person.class);
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }

        throw new IllegalArgumentException();
    }
}
