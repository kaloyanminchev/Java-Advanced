package SetsAndMaps;

import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            int damage = tokens[2].equals("null") ?
                    45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ?
                    250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ?
                    10 : Integer.parseInt(tokens[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>() {{
                    put(name, new int[]{damage, health, armor});
                }});
            } else {
                if (!dragons.get(type).containsKey(name)) {
                    dragons.get(type).put(name, new int[]{damage, health, armor});
                } else {
                    dragons.get(type).get(name)[0] = damage;
                    dragons.get(type).get(name)[1] = health;
                    dragons.get(type).get(name)[2] = armor;
                }
            }
        }

        dragons.entrySet()
                .forEach(entry -> {
                    double avgDamage;
                    double avgHealth;
                    double avgArmor;

                    int[] aggregatedData = new int[3];
                    StringBuilder builder = new StringBuilder();

                    entry.getValue().entrySet().forEach(innerEntry -> {
                        aggregatedData[0] += innerEntry.getValue()[0];
                        aggregatedData[1] += innerEntry.getValue()[1];
                        aggregatedData[2] += innerEntry.getValue()[2];

                        String outputLine = String.format("-%s -> damage: %d, health: %d, armor: %d",
                                innerEntry.getKey(),
                                innerEntry.getValue()[0],
                                innerEntry.getValue()[1],
                                innerEntry.getValue()[2]
                        );

                        builder.append(outputLine).append(System.lineSeparator());
                    });

                    int dragonsCount = entry.getValue().size();
                    avgDamage = aggregatedData[0] * 1.0 / dragonsCount;
                    avgHealth = aggregatedData[1] * 1.0 / dragonsCount;
                    avgArmor = aggregatedData[2] * 1.0 / dragonsCount;

                    System.out.println(String.format("%s::(%.2f/%.2f/%.2f)",
                            entry.getKey(),
                            avgDamage,
                            avgHealth,
                            avgArmor
                    ));

                    System.out.print(builder);
                });
    }
}
