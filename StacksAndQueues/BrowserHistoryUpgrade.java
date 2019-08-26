package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browsers = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if ("back".equals(input)) {
                if (browsers.size() > 1) {
                    forwards.push(browsers.pop());
                    System.out.println(browsers.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else if ("forward".equals(input)) {
                if (forwards.size() >= 1) {
                    browsers.push(forwards.pop());
                    System.out.println(browsers.peek());
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                System.out.println(input);
                browsers.push(input);
                forwards.clear();
            }

            input = scanner.nextLine();
        }
    }
}
