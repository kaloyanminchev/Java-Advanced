package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int bestSum = Integer.MIN_VALUE;
        int resultRow = -1;
        int resultCol = -1;

        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int currentSum = getMatrixSum(row, col);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        printResultMatrix(resultRow, resultCol);
    }

    private static void printResultMatrix(int resultRow, int resultCol) {
        int beginRow = resultRow - 1;
        int beginCol = resultCol - 1;
        for (int row = beginRow; row <= resultRow + 1; row++) {
            for (int col = beginCol; col <= resultCol + 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getMatrixSum(int row, int col) {
        int sum = 0;
        sum += matrix[row][col];
        sum += matrix[row][col - 1];
        sum += matrix[row][col + 1];
        sum += matrix[row - 1][col];
        sum += matrix[row + 1][col];
        sum += matrix[row - 1][col - 1];
        sum += matrix[row + 1][col + 1];
        sum += matrix[row + 1][col - 1];
        sum += matrix[row - 1][col + 1];

        return sum;
    }
}
