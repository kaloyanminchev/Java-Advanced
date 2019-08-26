package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[dim[0]][dim[1]];

        for (int row = 0; row < matrix.length; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < input.length; col++) {
                matrix[row][col] = input[col];
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int resultRow = -1;
        int resultCol = -1;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }

        System.out.println(matrix[resultRow][resultCol] + " " + matrix[resultRow][resultCol + 1]);
        System.out.println(matrix[resultRow + 1][resultCol] + " " + matrix[resultRow + 1][resultCol + 1]);
        System.out.println(bestSum);
    }
}
