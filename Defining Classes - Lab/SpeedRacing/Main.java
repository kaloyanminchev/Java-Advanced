package DefiningClasses.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int countCars = Integer.parseInt(reader.readLine());
        while (countCars-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            Car car = new Car(model,
                    Double.parseDouble(tokens[1]),
                    Double.parseDouble(tokens[2])
            );

            cars.putIfAbsent(model, car);
        }

        String input = reader.readLine();
        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");
            String carModel = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);

            if (!cars.get(carModel).drive(amountOfKm)) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = reader.readLine();
        }

        cars.forEach((key, value) -> System.out.println(value.getInfo()));
    }
}
