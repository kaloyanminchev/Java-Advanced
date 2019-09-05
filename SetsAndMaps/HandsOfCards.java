package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> outputCollection = new LinkedHashMap<>();
        Map<String, Set<String>> cardsEachPlayer = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"JOKER".equals(line)) {
            String[] tokens = line.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");

            cardsEachPlayer.putIfAbsent(name, new HashSet<>());
            cardsEachPlayer.get(name).addAll(Arrays.asList(cards));

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : cardsEachPlayer.entrySet()) {
            String name = entry.getKey();
            int totalValue = 0;
            for (String card : entry.getValue()) {
                String power = card.substring(0, card.length() - 1);
                char type = card.charAt(card.length() - 1);
                totalValue += getValue(power, type);
            }

            outputCollection.put(name, totalValue);
        }

        outputCollection.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static int getValue(String power, char type) {
        int value;
        int first;
        int second = 0;

        switch (power) {
            case "J":
                first = 11;
                break;
            case "Q":
                first = 12;
                break;
            case "K":
                first = 13;
                break;
            case "A":
                first = 14;
                break;
            default:
                first = Integer.parseInt(power);
                break;
        }

        switch (type) {
            case 'S':
                second = 4;
                break;
            case 'H':
                second = 3;
                break;
            case 'D':
                second = 2;
                break;
            case 'C':
                second = 1;
                break;
        }

        value = first * second;
        return value;
    }
}
