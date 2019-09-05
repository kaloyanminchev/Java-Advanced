package SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> parkingLot = new HashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String carNumber = tokens[1];

            if (direction.equalsIgnoreCase("in")) {
                parkingLot.add(carNumber);
            } else {
                parkingLot.remove(carNumber);
            }
        }

        System.out.println(parkingLot.isEmpty() ? "Parking Lot is Empty" : String.join(System.lineSeparator(), parkingLot));
    }
}
