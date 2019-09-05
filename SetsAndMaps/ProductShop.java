package SetsAndMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<String>> foodShop = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            foodShop.putIfAbsent(shop, new ArrayList<>());
            foodShop.get(shop).add(String.format("Product: %s, Price: %.1f", product, price));

            input = scanner.nextLine();
        }

        foodShop.forEach((shop, products) ->
                System.out.println(shop +
                        "->" +
                        System.lineSeparator() +
                        String.join(System.lineSeparator(), products))
        );
    }
}
