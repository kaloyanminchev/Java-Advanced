package DefiningClasses.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public boolean drive(int amountOfKm) {
        double fuelNeeded = this.fuelCostFor1km * amountOfKm;
        if (fuelNeeded <= this.fuelAmount) {
            this.fuelAmount -= fuelNeeded;
            distanceTraveled += amountOfKm;
            return true;
        }
        return false;
    }

    public String getInfo() {
        return String.format("%s %.2f %d",
                this.model,
                this.fuelAmount,
                this.distanceTraveled);
    }
}
