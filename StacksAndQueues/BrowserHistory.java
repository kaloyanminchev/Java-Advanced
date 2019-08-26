package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> browsers = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (!"back".equals(input)) {
                System.out.println(input);
                browsers.push(input);
            } else {
                if (browsers.size() > 1) {
                    browsers.pop();
                    System.out.println(browsers.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }
            input = scanner.nextLine();
        }

    }
}
