package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.valueOf(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(kids));

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        boolean primeCheck = true;
        if (cycle == 0 || cycle == 1) {
            primeCheck = false;
        } else {
            for (int i = 2; i < cycle; i++) {
                if (cycle % i == 0) {
                    primeCheck = false;
                }
            }
        }

        return primeCheck;
    }
}
