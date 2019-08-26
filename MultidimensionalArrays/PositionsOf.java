package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dim[0]][dim[1]];
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                matrix[row][col] = Integer.parseInt(elements[col]);
            }
        }

        int searchNum = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == searchNum) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
