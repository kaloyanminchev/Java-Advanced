package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[size[0]][size[1]];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split(", ");
            for (int col = 0; col < elements.length; col++) {
                sum += Integer.parseInt(elements[col]);
            }
        }

        System.out.println(size[0]);
        System.out.println(size[1]);
        System.out.println(sum);
    }
}
