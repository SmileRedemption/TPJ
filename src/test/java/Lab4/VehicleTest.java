package Lab4;


import Lab4.Cars.Car;
import Lab4.Cars.Vehicle;
import Lab4.Exceptions.VehicleIsFull;
import Lab4.Humans.Fireman;
import Lab4.Humans.Human;
import Lab4.Humans.Policeman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class VehicleTest {
    @Test
    void addPassengerTest() {
        Vehicle<Human> car = new Car<>(3);

        car.addPassenger(new Policeman("Lola"));
        car.addPassenger(new Fireman("Frank"));
        car.addPassenger(new Policeman("Crack"));

        assertEquals(car.getOccupiedPlace(), 3);
    }

    @Test
    void disembarkationOfPassengersTest() {
        Vehicle<Human> car = new Car<>(3);

        Policeman policeman = new Policeman("Lola");
        Fireman fireman = new Fireman("Frank");
        Human human = new Human("Crack");

        car.addPassenger(policeman);
        car.addPassenger(fireman);
        car.addPassenger(human);

        car.disembarkationOfPassengers(policeman);
        car.disembarkationOfPassengers(fireman);
        car.disembarkationOfPassengers(human);

        assertEquals(0, car.getOccupiedPlace());
    }

    @Test
    void addPassengerInFullVehicle() {
        Vehicle<Human> car = new Car<>(1);
        assertThrows(VehicleIsFull.class, () -> {
            car.addPassenger(new Human("Chuck"));
            car.addPassenger(new Human("Pack"));
        });
    }
}
