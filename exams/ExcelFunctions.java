package exams;

import java.util.*;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        String[][] table = new String[rows][];
        for (int r = 0; r < table.length; r++) {
            table[r] = scanner.nextLine().split(", ");
        }

        String[] tokens = scanner.nextLine().split("\\s+");
        String command = tokens[0];
        String header = tokens[1];

        int headerCol = findHeaderCol(header, table);

        switch (command) {
            case "hide":
                hideAndPrint(table, headerCol);
                break;
            case "sort":
                sortAndPrint(table, headerCol);
                break;
            case "filter":
                filterAndPrint(table, headerCol, tokens[2]);
                break;
        }
    }

    private static int findHeaderCol(String header, String[][] table) {
        int col = -1;
        for (int c = 0; c < table[0].length; c++) {
            if (header.equals(table[0][c])) {
                col = c;
                break;
            }
        }
        return col;
    }

    private static void hideAndPrint(String[][] table, int headerCol) {
        for (int r = 0; r < table.length; r++) {
            table[r][headerCol] = null;
        }

        for (String[] strings : table) {
            List<String> printList = new ArrayList<>();
            Arrays.stream(strings)
                    .filter(Objects::nonNull)
                    .forEach(printList::add);
            System.out.println(String.join(" | ", printList));
        }
    }

    private static void sortAndPrint(String[][] table, int headerCol) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 1; i < table.length - 1 - j; i++) {
                if (table[i][headerCol].compareTo(table[i + 1][headerCol]) > 0) {
                    String[] temp = table[i];
                    table[i] = table[i + 1];
                    table[i + 1] = temp;
                }
            }
        }

        for (String[] strings : table) {
            System.out.println(String.join(" | ", strings));
        }
    }

    private static void filterAndPrint(String[][] table, int headerCol, String value) {
        System.out.println(String.join(" | ", table[0]));
        for (int r = 1; r < table.length; r++) {
            if (table[r][headerCol].equals(value)) {
                System.out.println(String.join(" | ", table[r]));
            }
        }
    }
}
