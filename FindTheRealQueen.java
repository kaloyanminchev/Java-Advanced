package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen {

    private static char QUEEN = 'q';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;
        char[][] chessBoard = new char[size][size];
        for (int row = 0; row < chessBoard.length; row++) {
            String[] elements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                chessBoard[row][col] = elements[col].charAt(0);
            }
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (chessBoard[row][col] == QUEEN) {
                    if (isValidQueen(chessBoard, row, col)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] chessBoard, int row, int col) {
        return isQueenColumnValid(chessBoard, col) &&
                isQueenRowValid(chessBoard, row) &&
                isQueenFirstValid(chessBoard, row, col) &&
                isQueenSecondValid(chessBoard, row, col);
    }

    private static boolean isQueenColumnValid(char[][] chessBoard, int col) {
        int queenCount = 0;
        for (int i = 0; i < chessBoard.length; i++) {
            if (chessBoard[i][col] == QUEEN) {
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean isQueenRowValid(char[][] chessBoard, int row) {
        int queenCount = 0;
        for (int i = 0; i < chessBoard[row].length; i++) {
            if (chessBoard[row][i] == QUEEN) {
                queenCount++;
            }
        }
        return queenCount == 1;
    }

    private static boolean isQueenFirstValid(char[][] chessBoard, int row, int col) {
        int queenCount = 0;
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (chessBoard[row - i][col - i] == QUEEN) {
                queenCount++;
            }
        }

        for (int i = 1; row + i < chessBoard.length && col + i < chessBoard.length; i++) {
            if (chessBoard[row + i][col + i] == QUEEN) {
                queenCount++;
            }
        }
        return queenCount == 0;
    }

    private static boolean isQueenSecondValid(char[][] chessBoard, int row, int col) {
        int queenCount = 0;
        for (int i = 1; row - i >= 0 && col + i < chessBoard.length; i++) {
            if (chessBoard[row - i][col + i] == QUEEN) {
                queenCount++;
            }
        }

        for (int i = 1; row + i < chessBoard.length && col - i >= 0; i++) {
            if (chessBoard[row + i][col - i] == QUEEN) {
                queenCount++;
            }
        }
        return queenCount == 0;
    }
}
