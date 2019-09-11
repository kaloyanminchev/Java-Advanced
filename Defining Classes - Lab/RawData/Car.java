package Practice.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public boolean checkTires() {
        List<Tire> tires = this.tires;
        boolean isFragile = false;
        for (Tire tire : tires) {
            if (tire.getPressure() < 1) {
                isFragile = true;
                break;
            }
        }
        return isFragile;
    }

    public boolean checkPower() {
        boolean isFlamable = false;
        if (engine.getEnginePower() > 250) {
            isFlamable = true;
        }
        return isFlamable;
    }
}
