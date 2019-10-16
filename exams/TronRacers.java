package exams;

import java.util.*;

public class TronRacers {

    private static final char FIRST_PLAYER = 'f';
    private static final char SECOND_PLAYER = 's';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }

        int[] indexesFirstPlayer = findIndexes(matrix, FIRST_PLAYER);
        int[] indexesSecondPlayer = findIndexes(matrix, SECOND_PLAYER);

        int rowFirst = indexesFirstPlayer[0];
        int colFirst = indexesFirstPlayer[1];

        int rowSecond = indexesSecondPlayer[0];
        int colSecond = indexesSecondPlayer[1];

        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstPlayerCommand = tokens[0];
            String secondPlayerCommand = tokens[1];

            int[] newIndexesFirst = moveIndexes(firstPlayerCommand, rowFirst, colFirst, matrix);
            int[] newIndexesSecond = moveIndexes(secondPlayerCommand, rowSecond, colSecond, matrix);

            rowFirst = newIndexesFirst[0];
            colFirst = newIndexesFirst[1];
            rowSecond = newIndexesSecond[0];
            colSecond = newIndexesSecond[1];

            if (matrix[rowFirst][colFirst] == '*') {
                matrix[rowFirst][colFirst] = FIRST_PLAYER;
            } else if (matrix[rowFirst][colFirst] == SECOND_PLAYER) {
                matrix[rowFirst][colFirst] = 'x';
                break;
            }
            if (matrix[rowSecond][colSecond] == '*') {
                matrix[rowSecond][colSecond] = SECOND_PLAYER;
            } else if (matrix[rowSecond][colSecond] == FIRST_PLAYER) {
                matrix[rowSecond][colSecond] = 'x';
                break;
            }
        }

        printMatrix(matrix);
    }

    private static int[] findIndexes(char[][] matrix, char player) {
        int[] indexes = new int[2];
        boolean playerFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == player) {
                    indexes[0] = r;
                    indexes[1] = c;
                    playerFound = true;
                    break;
                }
            }
            if (playerFound) {
                break;
            }
        }
        return indexes;
    }

    private static int[] moveIndexes(String command, int row, int col, char[][] matrix) {
        int[] newIndexes = new int[2];
        switch (command) {
            case "up":
                if (row - 1 >= 0) {
                    row--;
                } else {
                    row = matrix.length - 1;
                }
                break;
            case "down":
                if (row + 1 < matrix.length) {
                    row++;
                } else {
                    row = 0;
                }
                break;
            case "left":
                if (col - 1 >= 0) {
                    col--;
                } else {
                    col = matrix.length - 1;
                }
                break;
            case "right":
                if (col + 1 < matrix.length) {
                    col++;
                } else {
                    col = 0;
                }
                break;
        }
        newIndexes[0] = row;
        newIndexes[1] = col;
        return newIndexes;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
