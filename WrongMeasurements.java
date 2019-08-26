package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];
        for (int row = 0; row < matrix.length; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < elements.length; col++) {
                matrix[row] = elements;
            }
        }

        String[] dimWrongValue = scanner.nextLine().split("\\s+");
        int wrongValue = matrix[Integer.parseInt(dimWrongValue[0])][Integer.parseInt(dimWrongValue[1])];

        int[][] resultMatrix = new int[size][];

        for (int row = 0; row < size; row++) {
            resultMatrix[row] = matrix[row].clone();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    resultMatrix[row][col] = getSum(matrix, row, col, wrongValue);
                }
            }
        }

        for (int[] ints : resultMatrix) {
            System.out.println(Arrays.toString(ints).replaceAll("[\\[\\],]", ""));
        }

    }

    private static int getSum(int[][] matrix, int row, int col, int wrongValue) {
        int sum = 0;
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }
}
