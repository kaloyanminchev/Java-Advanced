package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> kids = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(kids::offer);

        int toss = Integer.parseInt(scanner.nextLine());

        while (kids.size() > 1) {
            for (int i = 1; i < toss; i++) {
                kids.offer(kids.poll());
            }
            System.out.println("Removed " + kids.poll());
        }

        System.out.println("Last is " + kids.peek());
    }
}
