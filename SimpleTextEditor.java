package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();

        ArrayDeque<StringBuilder> stack = new ArrayDeque<>();

        for (int i = 0; i < countCommands; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    String string = tokens[1];
                    text.append(string);
                    stack.push(new StringBuilder(text));
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    for (int j = 0; j < count; j++) {
                        text.deleteCharAt(text.length() - 1);
                    }
//                    text.delete(text.length() - count, text.length());
                    stack.push(new StringBuilder(text));
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;
                case "4":
                    if (stack.size() > 1) {
                        stack.pop();
                        text = stack.peek();
                    } else if (stack.size() == 1) {
                        text = new StringBuilder();
                    }
                    break;
            }
        }

    }
}
