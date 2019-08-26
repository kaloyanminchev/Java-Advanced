package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String element : input) {
            if (Character.isDigit(element.charAt(0)) || Character.isLetter(element.charAt(0))) {
                outputQueue.offer(element);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(element);
                } else {
                    String lastOperator = operatorStack.peek();
                    switch (element) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operatorStack.push(element);
                            } else {
                                outputQueue.offer(operatorStack.pop());
                                operatorStack.push(element);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                outputQueue.offer(operatorStack.pop());
                                operatorStack.push(element);
                            } else {
                                operatorStack.push(element);
                            }
                            break;
                        case "(":
                            operatorStack.push(element);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                outputQueue.offer(operatorStack.pop());
                            }
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }
    }
}
