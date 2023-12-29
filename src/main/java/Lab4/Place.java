package Lab4;

import Lab4.Humans.Human;

public class Place<T extends Human> {
    private boolean isFree = true;
    private T human;

    public boolean isFree() {
        return isFree;
    }

    public T getHuman() {
        return human;
    }

    public void setHuman(T human) {
        this.human = human;
        isFree = false;
    }

    public T disembarkationPassenger() {
        isFree = true;
        return human;
    }
}
