package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int element = 1;
        for (int r = 0; r < rows; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < cols; c++) {
                row.add(element);
                element++;
            }
            matrix.add(row);
        }

        String input = scanner.nextLine();
        while (!"Nuke it from orbit".equals(input)) {
            int[] coordinates = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = coordinates[0];
            int col = coordinates[1];
            int radius = coordinates[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInBounds(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }
            }

            for (int c = col - radius; c <= col + radius; c++) {
                if (isInBounds(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }
            }

            for (int r = 0; r < matrix.size(); r++) {
//                matrix.get(r).removeAll(new ArrayList<Integer>(){{add(0);}});
                matrix.set(r, matrix.get(r).stream()
                        .filter(e -> e != 0)
                        .collect(Collectors.toCollection(ArrayList::new)));

                if (matrix.get(r).size() == 0) {
                    matrix.remove(r);
                    r--;
                }
            }

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }
}
