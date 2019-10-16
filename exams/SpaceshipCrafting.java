package exams;

import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(liquids::offer);

        ArrayDeque<Integer> items = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(items::push);

        TreeMap<String, Integer> advancedMaterials = new TreeMap<>() {{
            put("Glass", 0);
            put("Aluminium", 0);
            put("Lithium", 0);
            put("Carbon fiber", 0);
        }};

        while (!liquids.isEmpty() && !items.isEmpty()) {
            int currentLiquid = liquids.poll();
            int currentItem = items.pop();
            int sum = currentLiquid + currentItem;

            switch (sum) {
                case 25:
                    advancedMaterials.put("Glass", advancedMaterials.get("Glass") + 1);
                    break;
                case 50:
                    advancedMaterials.put("Aluminium", advancedMaterials.get("Aluminium") + 1);
                    break;
                case 75:
                    advancedMaterials.put("Lithium", advancedMaterials.get("Lithium") + 1);
                    break;
                case 100:
                    advancedMaterials.put("Carbon fiber", advancedMaterials.get("Carbon fiber") + 1);
                    break;
                default:
                    currentItem += 3;
                    items.push(currentItem);
                    break;
            }
        }

        if (spaceshipBuilt(advancedMaterials)) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            printLeftovers("Liquids left: ", liquids);
        }

        if (items.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            printLeftovers("Physical items left: ", items);
        }

        advancedMaterials.forEach((material, amount) -> System.out.println(String.format("%s: %d", material, amount)));
    }

    private static void printLeftovers(String string, ArrayDeque<Integer> deque) {
        ArrayList<String> output = new ArrayList<>();
        for (Integer element : deque) {
            output.add(String.valueOf(element));
        }
        System.out.println(string + String.join(", ", output));
    }

    private static boolean spaceshipBuilt(TreeMap<String, Integer> advancedMaterials) {
        return advancedMaterials.get("Glass") > 0
                && advancedMaterials.get("Aluminium") > 0
                && advancedMaterials.get("Lithium") > 0
                && advancedMaterials.get("Carbon fiber") > 0;
    }
}
