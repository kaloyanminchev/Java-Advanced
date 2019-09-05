package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>();

        while (n-- > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            firstNumbers.add(num);
        }

        while (m-- > 0) {
            int num = Integer.parseInt(scanner.nextLine());
            secondNumbers.add(num);
        }

        firstNumbers.retainAll(secondNumbers);
        for (Integer firstNumber : firstNumbers) {
            System.out.print(firstNumber + " ");
        }
    }
}
