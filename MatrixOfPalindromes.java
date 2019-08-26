package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[size[0]][size[1]];

        for (int row = 0; row < matrix.length; row++) {
            char firstLetter = (char) (97 + row);
            char lastLetter = (char) (97 + row);
            for (int col = 0; col < matrix[row].length; col++) {
                char middleLetter = (char) (97 + row + col);
                matrix[row][col] = "" + firstLetter + middleLetter + lastLetter;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
