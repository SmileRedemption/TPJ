package Lab4;

import Lab4.Cars.*;
import Lab4.Humans.Fireman;
import Lab4.Humans.Human;
import Lab4.Humans.Policeman;

public class Main {
    public static void main(String[] args) {
        Road road = new Road();

        Vehicle<Human> car = new Car<>(2);
        Vehicle<Human> bus = new Bus(20);
        Vehicle<Human> taxi = new Taxi(8);
        Vehicle<Fireman> fireEngine = new FireEngine(10);
        Vehicle<Policeman> policeCar = new PoliceCar(5);

        car.addPassenger(new Human("A"));
        bus.addPassenger(new Human("B"));
        bus.addPassenger(new Human("C"));
        bus.addPassenger(new Human("D"));
        bus.addPassenger(new Human("E"));
        bus.addPassenger(new Human("F"));
        bus.addPassenger(new Human("G"));

        taxi.addPassenger(new Human("H"));
        taxi.addPassenger(new Human("I"));
        fireEngine.addPassenger(new Fireman("J"));
        fireEngine.addPassenger(new Fireman("K"));
        fireEngine.addPassenger(new Fireman("L"));
        fireEngine.addPassenger(new Fireman("M"));
        fireEngine.addPassenger(new Fireman("N"));
        policeCar.addPassenger(new Policeman("O"));
        policeCar.addPassenger(new Policeman("p"));

        road.addCarToRoad(car);
        road.addCarToRoad(bus);
        road.addCarToRoad(taxi);
        road.addCarToRoad(fireEngine);
        road.addCarToRoad(policeCar);

        System.out.println("Кількість пассажирів на дорозі: " + road.getCountOfHumans());

    }
}
