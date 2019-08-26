package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimFirstMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] firstMatrix = new int[dimFirstMatrix[0]][dimFirstMatrix[1]];
        for (int row = 0; row < firstMatrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                firstMatrix[row][col] = Integer.parseInt(elements[col]);
            }
        }

        int[] dimSecondMatrix = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] secondMatrix = new int[dimSecondMatrix[0]][dimSecondMatrix[1]];
        for (int row = 0; row < secondMatrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                secondMatrix[row][col] = Integer.parseInt(elements[col]);
            }
        }

        if (isEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row].length != secondMatrix[row].length) {
                    return false;
                }
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
