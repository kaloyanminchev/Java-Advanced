package DefiningClasses.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public String getWeight() {
        return this.weight;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s",
                getModel(),
                getEngine().getModel(),
                getEngine().getPower(),
                getEngine().getDisplacement(),
                getEngine().getEfficiency(),
                getWeight(),
                getColor());
    }
}
