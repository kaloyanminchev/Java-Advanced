package StacksAndQueues;

import java.util.*;

public class RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        long result = getFib(n);
        System.out.println(result);
    }

    private static long getFib(int n) {
        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = getFib(n - 1) + getFib(n - 2);
    }
}

