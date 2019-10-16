package exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWaves = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> plates = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(plates::offer);

        for (int wave = 1; wave <= countWaves; wave++) {
            ArrayDeque<Integer> warriors = new ArrayDeque<>();
            Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(warriors::push);

            if (wave % 3 == 0) {
                plates.offer(Integer.parseInt(scanner.nextLine()));
            }

            while (!plates.isEmpty() && !warriors.isEmpty()) {
                int currentPlate = plates.poll();
                int currentWarrior = warriors.pop();

                if (currentPlate < currentWarrior) {
                    currentWarrior -= currentPlate;
                    warriors.push(currentWarrior);
                } else if (currentPlate > currentWarrior) {
                    currentPlate -= currentWarrior;
                    plates.push(currentPlate);
                }
            }

            if (plates.isEmpty()) {
                System.out.println("The Trojans successfully destroyed the Spartan defense.");
                System.out.print("Warriors left: " + warriors.toString().replaceAll("[\\[\\]]", ""));
                return;
            }
        }

        System.out.println("The Spartans successfully repulsed the Trojan attack.");
        System.out.print("Plates left: " + plates.toString().replaceAll("[\\[\\]]", ""));
    }
}
