package SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> chemicals = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            chemicals.addAll(Arrays.asList(scanner.nextLine().split("\\s+")));
        }

        System.out.println(String.join(" ", chemicals));
    }
}
