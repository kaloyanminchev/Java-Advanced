package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String rotation = scanner.nextLine();
//        int degrees = Integer.parseInt(rotation.substring(7, rotation.length() - 1));

        String[] rotateData = scanner.nextLine().split("[()]+");
        int rotateAngle = Integer.parseInt(rotateData[1]) % 360;

        List<String> inputData = new ArrayList<>();

        String input = scanner.nextLine();
        int maxLength = input.length();

        while (!"END".equals(input)) {
            inputData.add(input);
            input = scanner.nextLine();
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }

        char[][] matrix = new char[inputData.size()][maxLength];

        for (int row = 0; row < inputData.size(); row++) {
            for (int col = 0; col < maxLength; col++) {
                if (col > inputData.get(row).length() - 1) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = inputData.get(row).charAt(col);
                }
            }
        }

        if (rotateAngle == 90) {
            for (int col = 0; col < maxLength; col++) {
                for (int row = 0; row < inputData.size(); row++) {
                    System.out.print(matrix[inputData.size() - 1 - row][col]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 180) {
            for (int row = 0; row < inputData.size(); row++) {
                for (int col = 0; col < maxLength; col++) {
                    System.out.print(matrix[inputData.size() - 1 - row][maxLength - 1 - col]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 270) {
            for (int col = 0; col < maxLength; col++) {
                for (int row = 0; row < inputData.size(); row++) {
                    System.out.print(matrix[row][maxLength - 1 - col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < inputData.size(); row++) {
                for (int col = 0; col < maxLength; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
