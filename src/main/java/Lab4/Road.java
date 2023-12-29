package Lab4;


import Lab4.Cars.Vehicle;
import Lab4.Humans.Human;

import java.util.ArrayList;
import java.util.List;

public class Road {
    public List<Vehicle<? extends Human>> carsInRoad = new ArrayList<>();

    public int getCountOfHumans() {
        int numberOfPassengersOnTheRoad = 0;
        for (Vehicle<? extends Human> vehicle : carsInRoad) {
            numberOfPassengersOnTheRoad += vehicle.getOccupiedPlace();
        }
        return numberOfPassengersOnTheRoad;
    }

    public void addCarToRoad(Vehicle<? extends Human> vehicle) {
        if (!carsInRoad.contains(vehicle)) {
            carsInRoad.add(vehicle);
        }
    }

    public void removeCarFromRoad(Vehicle<? extends Human> vehicle) {
        carsInRoad.remove(vehicle);
    }
}
