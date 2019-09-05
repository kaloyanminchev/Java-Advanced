package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> dataCountries = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            dataCountries.putIfAbsent(country, new LinkedHashMap<>());
            dataCountries.get(country).put(city, population);

            input = scanner.nextLine();
        }

        dataCountries.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    long second = e2.getValue().values()
                            .stream()
                            .mapToLong(integer -> integer)
                            .sum();
                    long first = e1.getValue().values()
                            .stream()
                            .mapToLong(integer -> integer)
                            .sum();
                    return Long.compare(second, first);
                })
                .forEach(entry -> {
                    long totalPopulation = entry.getValue().values().stream().mapToLong(i -> i).sum();
                    System.out.println(String.format("%s (total population: %d)", entry.getKey(), totalPopulation));
                    entry.getValue().entrySet()
                            .stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(innerEntry -> System.out.println(String.format("=>%s: %d", innerEntry.getKey(), innerEntry.getValue())));
                });
    }
}
