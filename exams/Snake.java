package exams;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split(", ");

        String[][] field = new String[size][size];
        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().split("\\s+");
        }

        int[] snakeIndexes = findSnakeAndFood(field);
        int rowSnake = snakeIndexes[0];
        int colSnake = snakeIndexes[1];
        int foodCount = snakeIndexes[2];

        int snakeLength = 1;

        for (String command : tokens) {
            switch (command) {
                case "left":
                    if (colSnake - 1 >= 0) {
                        colSnake--;
                    } else {
                        colSnake = field.length - 1;
                    }
                    break;
                case "right":
                    if (colSnake + 1 < field.length) {
                        colSnake++;
                    } else {
                        colSnake = 0;
                    }
                    break;
                case "up":
                    if (rowSnake - 1 >= 0) {
                        rowSnake--;
                    } else {
                        rowSnake = field.length - 1;
                    }
                    break;
                case "down":
                    if (rowSnake + 1 < field.length) {
                        rowSnake++;
                    } else {
                        rowSnake = 0;
                    }
                    break;
            }

            String currentSymbol = field[rowSnake][colSnake];
            if (currentSymbol.equals("f")) {
                snakeLength++;
                field[rowSnake][colSnake] = "s";

                foodCount--;
                if (foodCount == 0) {
                    System.out.println("You win! Final snake length is " + snakeLength);
                    return;
                }
            } else if (currentSymbol.equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }

        System.out.println(String.format("You lose! There is still %d food to be eaten.", foodCount));
    }

    private static int[] findSnakeAndFood(String[][] field) {
        int[] indexes = new int[3];
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c].equals("s")) {
                    indexes[0] = r;
                    indexes[1] = c;
                } else if (field[r][c].equals("f")) {
                    indexes[2]++;
                }
            }
        }
        return indexes;
    }
}

