package exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> IDs = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(IDs::push);

        ArrayDeque<String> agents = new ArrayDeque<>(Arrays.asList(scanner.nextLine().split("\\s+")));

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "add-ID":
                    IDs.push(tokens[1]);
                    break;
                case "add-agent":
                    agents.offer(tokens[1]);
                    break;
                case "remove-ID":
                    System.out.println(String.format("%s has been removed.", IDs.pop()));
                    break;
                case "remove-agent":
                    System.out.println(String.format("%s has left the queue.", agents.pollLast()));
                    break;
                case "sort-ID":
                    IDs = IDs.stream()
                            .sorted((f, s) -> Integer.compare(Integer.parseInt(s), Integer.parseInt(f)))
                            .collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }

            input = scanner.nextLine();
        }

        while (!agents.isEmpty() && !IDs.isEmpty()) {
            System.out.println(String.format("%s takes ID number: %s", agents.poll(), IDs.pop()));
        }
        if (!IDs.isEmpty()) {
            System.out.println("No more agents left.");
            while (!IDs.isEmpty()) {
                System.out.println("ID number: " + IDs.pop());
            }
        }
        while (!agents.isEmpty()) {
            System.out.println(agents.poll() + " does not have an ID.");
        }
    }
}

