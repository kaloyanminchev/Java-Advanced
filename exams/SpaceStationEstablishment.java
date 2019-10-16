package exams;

import java.util.Scanner;

public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] space = new char[size][size];

        int playerRow = -1, playerCol = -1;

        for (int r = 0; r < space.length; r++) {
            String line = scanner.nextLine();
            space[r] = line.toCharArray();

            int playerIndex = line.indexOf('S');
            if (playerIndex >= 0) {
                playerRow = r;
                playerCol = playerIndex;
            }
        }

        int energy = 0;
        boolean playerInField = true;

        while (true) {
            space[playerRow][playerCol] = '-';
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerInField = false;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= space.length) {
                        playerInField = false;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerInField = false;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= space.length) {
                        playerInField = false;
                    }
                    break;
            }

            if (!playerInField) {
                System.out.println("Bad news, the spaceship went to the void.");
                break;
            }

            if (Character.isDigit(space[playerRow][playerCol])) {
                energy += space[playerRow][playerCol] - '0';
                if (energy >= 50) {
                    space[playerRow][playerCol] = 'S';
                    System.out.println("Good news! Stephen succeeded in collecting enough star power!");
                    break;
                }
            }

            if (Character.isLetter(space[playerRow][playerCol])) {
                space[playerRow][playerCol] = '-';
                int[] blackHoleIndexes = findIndexes(space, playerRow, playerCol);
                playerRow = blackHoleIndexes[0];
                playerCol = blackHoleIndexes[1];
            }
        }

        System.out.println("Star power collected: " + energy);
        printMatrix(space);
    }

    private static int[] findIndexes(char[][] space, int playerRow, int playerCol) {
        int[] indexes = new int[2];
        for (int r = 0; r < space.length; r++) {
            for (int c = 0; c < space[r].length; c++) {
                if (space[r][c] == 'O') {
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
