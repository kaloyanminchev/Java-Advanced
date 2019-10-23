package exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MakeSalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(vegetables::offer);

        ArrayDeque<Integer> salads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(salads::push);

        while (!vegetables.isEmpty() && !salads.isEmpty()) {
            int currentSalad = salads.peek();
            while (currentSalad > 0 && !vegetables.isEmpty()) {
                String currentVegetable = vegetables.poll();
                int caloriesCurrentVegetable = 0;

                switch (currentVegetable) {
                    case "tomato":
                        caloriesCurrentVegetable = 80;
                        break;
                    case "carrot":
                        caloriesCurrentVegetable = 136;
                        break;
                    case "lettuce":
                        caloriesCurrentVegetable = 109;
                        break;
                    case "potato":
                        caloriesCurrentVegetable = 215;
                        break;
                }

                currentSalad -= caloriesCurrentVegetable;
            }

            System.out.print(salads.pop() + " ");
        }

        System.out.println();
        while (salads.size() > 0) {
            System.out.print(salads.pop() + " ");
        }
        while (vegetables.size() > 0) {
            System.out.print(vegetables.poll() + " ");
        }
    }
}
