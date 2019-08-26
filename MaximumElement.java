package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        int countCommands = Integer.parseInt(scanner.nextLine());

        while (countCommands-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    numbers.push(element);
                    break;
                case "2":
                    numbers.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(numbers));
//                    System.out.println(numbers.stream().max(Integer::compareTo).get()); // 2ND SOLUTION
                    break;
            }
        }
    }
}
