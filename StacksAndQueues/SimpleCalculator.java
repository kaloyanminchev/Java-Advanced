package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>(Arrays.asList(input));

        while (stack.size()> 1) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.valueOf(stack.pop());

            if (operator.equals("+")) {
                stack.push(first + second + "");
            } else if (operator.equals("-")) {
                stack.push(first - second + "");
            }
        }

        System.out.println(stack.peek());
    }
}
