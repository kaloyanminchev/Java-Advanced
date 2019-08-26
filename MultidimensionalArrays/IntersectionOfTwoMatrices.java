package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countRows = Integer.parseInt(scanner.nextLine());
        int countCols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[countRows][countCols];
        char[][] secondMatrix = new char[countRows][countCols];

        for (int row = 0; row < firstMatrix.length * 2; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                if (row < countRows) {
                    firstMatrix[row][col] = elements[col].charAt(0);
                } else {
                    secondMatrix[row - countRows][col] = elements[col].charAt(0);
                }
            }
        }

        char[][] resultMatrix = new char[countRows][countCols];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = '*';
                }
            }
        }

        for (char[] matrix : resultMatrix) {
            System.out.println(Arrays.toString(matrix).replaceAll("[\\[\\],]", ""));
        }
    }
}
