package exams;

import java.util.Scanner;

public class HelenAbduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
        }

        int[] indexes = findIndexes(matrix);
        int parisRow = indexes[0];
        int parisCol = indexes[1];

        matrix[parisRow][parisCol] = '-';

        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int spawnRow = Integer.parseInt(tokens[1]);
            int spawnCol = Integer.parseInt(tokens[2]);

            matrix[spawnRow][spawnCol] = 'S';

            energy--;

            switch (command) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < matrix.length) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < matrix.length) {
                        parisCol++;
                    }
                    break;
            }

            if (matrix[parisRow][parisCol] == 'H') {
                matrix[parisRow][parisCol] = '-';
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
                break;
            }
            if (energy <= 0) {
                matrix[parisRow][parisCol] = 'X';
                System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
                break;
            }
            if (matrix[parisRow][parisCol] == 'S') {
                if (energy - 2 > 0) {
                    energy -= 2;
                    matrix[parisRow][parisCol] = '-';
                } else {
                    matrix[parisRow][parisCol] = 'X';
                    System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
                    break;
                }
            }
        }

        printMatrix(matrix);
    }

    private static int[] findIndexes(char[][] matrix) {
        int[] indexes = new int[2];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    indexes[0] = r;
                    indexes[1] = c;
                }
            }
        }
        return indexes;
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
