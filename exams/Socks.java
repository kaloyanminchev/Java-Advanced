package exams;

import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(leftSocks::push);

        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(rightSocks::offer);

        List<Integer> pairs = new ArrayList<>();

        while (!leftSocks.isEmpty() && !rightSocks.isEmpty()) {
            int right = rightSocks.poll();
            int left = leftSocks.pop();

            if (left > right) {
                pairs.add(left + right);
            } else if (left < right) {
                rightSocks.push(right);
            } else {
                left++;
                leftSocks.push(left);
            }
        }

        System.out.println(Collections.max(pairs));
        pairs.forEach(pair -> System.out.print(pair + " "));
//        System.out.println(pairs.toString().replaceAll("[\\[\\],]", ""));
    }
}
