package SetsAndMaps;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> first = new LinkedHashSet<>();
        LinkedHashSet<Integer> second = new LinkedHashSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(first::add);
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(second::add);

        int rounds = 50;
        while (rounds-- >= 0) {
            if (first.isEmpty() || second.isEmpty()) {
                break;
            }

            Iterator<Integer> firstPlayerIterator = first.iterator();
            Iterator<Integer> secondPlayerIterator = second.iterator();

            int firstPlayerValue = firstPlayerIterator.next();
            first.remove(firstPlayerValue);
            int secondPlayerValue = secondPlayerIterator.next();
            second.remove(secondPlayerValue);

            if (firstPlayerValue > secondPlayerValue) {
                first.add(firstPlayerValue);
                first.add(secondPlayerValue);
            } else if (firstPlayerValue < secondPlayerValue) {
                second.add(secondPlayerValue);
                second.add(firstPlayerValue);
            }
        }

        if (first.size() > second.size()) {
            System.out.println("First player win!");
        } else if (first.size() < second.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
