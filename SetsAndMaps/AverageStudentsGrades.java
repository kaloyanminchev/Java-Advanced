package SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, List<Double>> students = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);
        }

        students.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(entry -> {
                    String allGrades = entry.getValue().stream()
                            .map(e -> String.format("%.2f", e))
                            .collect(Collectors.joining(" "));
                    double avg = entry.getValue().stream().mapToDouble(e -> e).sum() / entry.getValue().size();
                    System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), allGrades, avg);
                });
    }
}
