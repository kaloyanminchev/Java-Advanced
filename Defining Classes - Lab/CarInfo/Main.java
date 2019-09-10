package Practice.CarInfo;

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
            String make = tokens[0];
            if (tokens.length > 1) {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);

                Car car = new Car(make, model, horsePower);
                cars.add(car);
            } else {
                Car car = new Car(make);
                cars.add(car);
            }
        }

        cars.forEach(c -> System.out.println(c.getInfo()));
    }
}
