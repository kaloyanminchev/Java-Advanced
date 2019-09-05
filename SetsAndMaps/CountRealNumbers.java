package SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> counter = new LinkedHashMap<>();

        double[] inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        for (double number : inputNumbers) {
            if (!counter.containsKey(number)) {
                counter.put(number, 1);
            } else {
                counter.put(number, counter.get(number) + 1);
            }
        }

        counter.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
