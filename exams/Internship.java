package exams;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Internship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemsCount = Integer.parseInt(scanner.nextLine());
        int candidatesCount = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> problems = new ArrayDeque<>();
        while (problemsCount-- > 0) {
            problems.push(scanner.nextLine());
        }

        ArrayDeque<String> candidates = new ArrayDeque<>();
        while (candidatesCount-- > 0) {
            String name = scanner.nextLine();
            Matcher matcher = Pattern
                    .compile("^[A-Z][a-z]+ [A-Z][a-z]+$")
                    .matcher(name);
            if (matcher.find()) {
                candidates.offer(name);
            }
        }

        while (!problems.isEmpty()) {
            if (candidates.size() == 1) {
                System.out.println(String.format("%s gets the job!", candidates.peek()));
                return;
            }

            String currentProblem = problems.pop();
            String currentCandidate = candidates.poll();

            int problemSum = 0;
            for (int i = 0; i < currentProblem.length(); i++) {
                problemSum += currentProblem.charAt(i);
            }

            int candidateSum = 0;
            for (int i = 0; i < currentCandidate.length(); i++) {
                candidateSum += currentCandidate.charAt(i);
            }

            if (candidateSum > problemSum) {
                candidates.offer(currentCandidate);
                System.out.println(String.format("%s solved %s.", currentCandidate, currentProblem));
            } else {
                problems.addLast(currentProblem);
                System.out.println(String.format("%s failed %s.", currentCandidate, currentProblem));
            }
        }

        System.out.println(String.join(", ", candidates));
    }
}
