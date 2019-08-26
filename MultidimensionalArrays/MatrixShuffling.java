package MultidimensionalArrays;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }

        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            if (tokens[0].equals("swap") && tokens.length == 5) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                if (isValidIndex(row1, col1, rows, cols) && isValidIndex(row2, col2, rows, cols)) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[row].length; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static boolean isValidIndex(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
