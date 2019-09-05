package SetsAndMaps;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> collection = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!collection.containsKey(continent)) {
                collection.put(continent, new LinkedHashMap<>());
                collection.get(continent).put(country, new ArrayList<>());
                collection.get(continent).get(country).add(city);
            } else {
                if (!collection.get(continent).containsKey(country)) {
                    collection.get(continent).put(country, new ArrayList<>());
                    collection.get(continent).get(country).add(city);
                } else {
                    collection.get(continent).get(country).add(city);
                }
            }
        }

        collection.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, cities) -> System.out.println(String.format("%s -> %s", country, String.join(", ", cities))));
        });
    }
}
