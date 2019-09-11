package Practice.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            Engine engine = new Engine(Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2]));

            Cargo cargo = new Cargo(Integer.parseInt(tokens[3]),
                    tokens[4]);

            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < tokens.length; i += 2) {
                Tire tire = new Tire(Double.parseDouble(tokens[i]), Integer.parseInt(tokens[i + 1]));
                tires.add(tire);
            }

            Car car = new Car(tokens[0],
                    engine,
                    cargo,
                    tires
            );

            cars.add(car);
        }

        String type = scanner.nextLine();
        if ("fragile".equals(type)) {
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equals("fragile") && car.checkTires()) {
                    System.out.println(car.getModel());
                }
            }

        } else {
            for (Car car : cars) {
                if (car.getCargo().getCargoType().equals("flamable") && car.checkPower()) {
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
