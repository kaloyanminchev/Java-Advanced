package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int elementsToAdd = scanner.nextInt();
        int elementsToRemove = scanner.nextInt();
        int searchElement = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(elementsToAdd)
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        while (elementsToRemove-- > 0) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(searchElement)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
