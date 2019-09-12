package DefiningClasses.Google;

public class Car {
    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getInfo() {
        return String.format("%s %d", this.model, this.speed);
    }
}
