package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dim][dim];
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

                matrix[row] = elements;
        }

        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
    }
}
