package SetsAndMaps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double[]> output = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

            output.put(name, new Double[grades.length]);
            for (int i = 0; i < grades.length; i++) {
                output.get(name)[i] = grades[i];
            }
        }

        output.forEach((student, grades) -> {
            double sum = 0;
            for (Double grade : grades) {
                sum += grade;
            }
            double avg = sum / grades.length;
            System.out.printf("%s is graduated with %s%n", student, avg);
        });
    }
}
