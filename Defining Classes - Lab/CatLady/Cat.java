package Practice.CatLady;

public class Cat {
    private String name;
    private double specialValue;

    public Cat(String name, double specialValue) {
        this.name = name;
        this.specialValue = specialValue;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", this.name, this.specialValue);
    }
}
