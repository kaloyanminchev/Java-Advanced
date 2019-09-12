package DefiningClasses.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Engine> engines = new HashMap<>();

        int countEngines = Integer.parseInt(reader.readLine());
        while (countEngines-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            String modelEngine = tokens[0];
            Engine engine = new Engine(modelEngine, Integer.parseInt(tokens[1]));

            if (tokens.length == 3) {
                if (Character.isLetter(tokens[2].charAt(0))) {
                    engine.setEfficiency(tokens[2]);
                } else {
                    engine.setDisplacement(tokens[2]);
                }
            } else if (tokens.length == 4) {
                engine.setDisplacement(tokens[2]);
                engine.setEfficiency(tokens[3]);
            }

            engines.putIfAbsent(modelEngine, engine);
        }

        List<Car> cars = new ArrayList<>();

        int countCars = Integer.parseInt(reader.readLine());
        while (countCars-- > 0) {

            String[] tokens = reader.readLine().split("\\s+");

            String modelCar = tokens[0];
            Car car = new Car(modelCar, engines.get(tokens[1]));

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    car.setWeight(tokens[2]);
                } else {
                    car.setColor(tokens[2]);
                }
            } else if (tokens.length == 4) {
                car.setWeight(tokens[2]);
                car.setColor(tokens[3]);
            }

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
