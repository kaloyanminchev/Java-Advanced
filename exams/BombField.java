package exams;

import java.util.Scanner;

public class BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split(",");

        char[][] field = new char[size][size];
        for (int r = 0; r < field.length; r++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int c = 0; c < elements.length; c++) {
                field[r][c] = elements[c].charAt(0);
            }
        }

        int[] indexes = findSapperAndBombs(field);
        int sapperRow = indexes[0];
        int sapperCol = indexes[1];
        int countBombs = indexes[2];

        for (String token : tokens) {
            field[sapperRow][sapperCol] = '+';
            switch (token) {
                case "up":
                    if (sapperRow - 1 >= 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow + 1 < field.length) {
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol - 1 >= 0) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol + 1 < field.length) {
                        sapperCol++;
                    }
                    break;
            }

            if (field[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                countBombs--;
                field[sapperRow][sapperCol] = '+';

                if (countBombs == 0) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (field[sapperRow][sapperCol] == 'e') {
                System.out.println(String.format("END! %d bombs left on the field", countBombs));
                return;
            }
        }

        System.out.println(String.format("%d bombs left on the field. Sapper position: (%d,%d)",
                countBombs,
                sapperRow,
                sapperCol));
    }

    private static int[] findSapperAndBombs(char[][] field) {
        int[] indexes = new int[3];
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field.length; c++) {
                if (field[r][c] == 's') {
                    indexes[0] = r;
                    indexes[1] = c;
                } else if (field[r][c] == 'B') {
                    indexes[2]++;
                }
            }
        }
        return indexes;
    }
}
