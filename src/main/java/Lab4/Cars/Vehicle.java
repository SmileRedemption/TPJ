package Lab4.Cars;

import Lab4.Humans.Human;
import Lab4.Exceptions.HumanNotInVehicle;
import Lab4.Place;
import Lab4.Exceptions.VehicleIsFull;

import java.util.HashSet;
import java.util.Set;

public abstract class Vehicle<T extends Human> {
    private final Set<Place<T>> passengers;
    private final int maxCountOfPlace;

    public Vehicle(int maxCountOfPlace) {
        passengers = new HashSet<>();
        this.maxCountOfPlace = maxCountOfPlace;
    }

    public int getCountOfPlace() {
        return maxCountOfPlace;
    }

    public int getOccupiedPlace() {
        return passengers.size();
    }

    public void addPassenger(T human){
        if (passengers.size() == maxCountOfPlace)
            throw new VehicleIsFull();

        Place<T> place = new Place<>();
        place.setHuman(human);
        passengers.add(place);
    }

    public T disembarkationOfPassengers(T human){
        for (var place : passengers) {
            if (place.getHuman() == human){
                passengers.remove(place);
                return place.disembarkationPassenger();
            }
        }

        throw new HumanNotInVehicle();
    }
}


