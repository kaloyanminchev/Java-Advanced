package SetsAndMaps;

import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        TreeMap<String, Integer> junk = new TreeMap<>();

        boolean hasReached = false;
        do {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if ("shards".equals(material)
                        || "fragments".equals(material)
                        || "motes".equals(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + quantity);
                }

                if (keyMaterials.containsKey(material) && keyMaterials.get(material) >= 250) {
                    keyMaterials.put(material, keyMaterials.get(material) - 250);
                    String result = "";
                    switch (material) {
                        case "shards":
                            result = "Shadowmourne obtained!";
                            break;
                        case "fragments":
                            result = "Valanyr obtained!";
                            break;
                        case "motes":
                            result = "Dragonwrath obtained!";
                            break;
                    }
                    System.out.println(result);
                    hasReached = true;
                    break;
                }
            }
        } while (!hasReached);

        keyMaterials.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue())));

        junk.forEach((key, value) -> System.out.println(String.format("%s: %d", key, value)));
    }
}
