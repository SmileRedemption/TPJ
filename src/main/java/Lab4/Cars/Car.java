package Lab4.Cars;

import Lab4.Humans.Human;

public class Car<T extends Human> extends Vehicle<T> {
    public Car(int maxCountOfPlace) {
        super(maxCountOfPlace);
    }
}
