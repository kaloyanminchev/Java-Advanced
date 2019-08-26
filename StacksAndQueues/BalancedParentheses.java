package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Character> sequence = new ArrayDeque<>();
        String brackets = reader.readLine();
        boolean isBalanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            char ch = brackets.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                sequence.push(ch);
            } else {
                if (!sequence.isEmpty()) {
                    if (ch == (char) (sequence.peek() + 1) || ch == (char) (sequence.peek() + 2)) {
                        sequence.pop();
                    } else {
                        isBalanced = false;
                        break;
                    }
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
