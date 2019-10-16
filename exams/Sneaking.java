package exams;

import java.util.Scanner;

public class Sneaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] room = new char[size][];
        for (int r = 0; r < room.length; r++) {
            room[r] = scanner.nextLine().toCharArray();
        }

        int[] indexesNiko = findIndexes(room, 'N');
        int rowNiko = indexesNiko[0], colNiko = indexesNiko[1];

        int[] indexesSam = findIndexes(room, 'S');
        int rowSam = indexesSam[0], colSam = indexesSam[1];

        int counter = 0;
        char[] tokens = scanner.nextLine().toCharArray();

        boolean killedSam = false;

        while (true) {
            moveEnemy(room);
            for (int c = 0; c < colSam; c++) {
                if (room[rowSam][c] == 'b') {
                    killedSam = true;
                    room[rowSam][colSam] = 'X';
                    break;
                }
            }
            for (int c = colSam + 1; c < room[rowSam].length; c++) {
                if (room[rowSam][c] == 'd') {
                    killedSam = true;
                    room[rowSam][colSam] = 'X';
                    break;
                }
            }

            if (killedSam) {
                System.out.println(String.format("Sam died at %d, %d", rowSam, colSam));
                break;
            }

            room[rowSam][colSam] = '.';

            switch (tokens[counter]) {
                case 'U':
                    rowSam--;
                    break;
                case 'D':
                    rowSam++;
                    break;
                case 'L':
                    colSam--;
                    break;
                case 'R':
                    colSam++;
                    break;
            }
            counter++;

            if (room[rowSam][colSam] == 'b' || room[rowSam][colSam] == 'd') {
                room[rowSam][colSam] = 'S';
            }

            if (rowNiko == rowSam) {
                room[rowNiko][colNiko] = 'X';
                room[rowSam][colSam] = 'S';
                System.out.println("Nikoladze killed!");
                break;
            }
        }

        printRoom(room);
    }

    private static int[] findIndexes(char[][] room, char ch) {
        int[] indexes = new int[2];
        for (int r = 0; r < room.length; r++) {
            for (int c = 0; c < room[r].length; c++) {
                if (room[r][c] == ch) {
                    indexes[0] = r;
                    indexes[1] = c;
                }
            }
        }
        return indexes;
    }

    private static void moveEnemy(char[][] room) {
        for (int r = 0; r < room.length; r++) {
            for (int c = 0; c < room[r].length; c++) {
                if (room[r][c] == 'b') {
                    if (c < room[r].length - 1) {
                        room[r][c] = '.';
                        room[r][c + 1] = 'b';
                        c++;
                    } else {
                        room[r][c] = 'd';
                    }
                } else if (room[r][c] == 'd') {
                    if (c > 0) {
                        room[r][c] = '.';
                        room[r][c - 1] = 'd';
                    } else {
                        room[r][c] = 'b';
                    }
                }
            }
        }
    }

    private static void printRoom(char[][] room) {
        for (int r = 0; r < room.length; r++) {
            for (int c = 0; c < room[r].length; c++) {
                System.out.print(room[r][c]);
            }
            System.out.println();
        }
    }
}
