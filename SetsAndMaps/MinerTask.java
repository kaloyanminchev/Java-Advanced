package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> collection = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String resource = input;
            int qty = Integer.parseInt(scanner.nextLine());


            collection.putIfAbsent(resource, 0);
            collection.put(resource, collection.get(resource) + qty);

            input = scanner.nextLine();
        }

        collection.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
