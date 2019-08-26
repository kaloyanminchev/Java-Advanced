package StacksAndQueues;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");
        int elementsCount = Integer.parseInt(elements[0]);
        int elementsToRemove = Integer.parseInt(elements[1]);
        String searchElement = elements[2];

        ArrayDeque<String> numbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(elementsCount)
                .forEach(numbers::push);

        for (int i = 0; i < elementsToRemove; i++) {
            numbers.pop();
        }

        if (numbers.contains(searchElement)) {
            System.out.println("true");
        } else {
            if (numbers.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(numbers)); // 1ST SOLUTION
//                numbers.stream()
//                        .sorted(Comparator.naturalOrder())
//                        .limit(1).forEach(System.out::println); // 2ND SOLUTION

//                int min = Integer.MAX_VALUE; // 3RD SOLUTION
//                while (numbers.size() > 0) {
//                    int number = Integer.parseInt(numbers.pop());
//                    if (number < min) {
//                        min = number;
//                    }
//                }
//                System.out.println(min);
            }
        }
    }
}
