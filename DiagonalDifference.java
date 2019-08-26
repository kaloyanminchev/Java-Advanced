package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];
        for (int row = 0; row < size; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < elements.length; col++) {
                matrix[row] = elements;
            }
        }

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < size; row++) {
            primaryDiagonal += matrix[row][row];
        }
        for (int row = 0; row < size; row++) {
            secondaryDiagonal += matrix[size - 1 - row][row];
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }
}
