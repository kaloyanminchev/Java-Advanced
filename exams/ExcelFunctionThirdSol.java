package exams;

import java.util.*;
import java.util.stream.Collectors;

public class ExcelFunctionThirdSol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        List<String> lineHeader = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        List<List<String>> table = new ArrayList<>();
        for (int r = 0; r < rows - 1; r++) {
            List<String> currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .collect(Collectors.toList());
            table.add(currentRow);
        }

        String[] command = scanner.nextLine().split("\\s+");
        String header = command[1];

        switch (command[0]) {
            case "hide":
                hide(lineHeader, table, header);
                lineHeader.remove(header);
                break;
            case "sort":
                table = sort(lineHeader, table, header);
                break;
            case "filter":
                String value = command[2];
                table = filter(lineHeader, table, header, value);
                break;
        }

        System.out.println(String.join(" | ", lineHeader));
        for (List<String> currentRow : table) {
            System.out.println(String.join(" | ", currentRow));
        }
    }

    private static void hide(List<String> lineHeader, List<List<String>> table, String header) {
        int indexToRemove = lineHeader.indexOf(header);
        table.forEach(row -> row.remove(indexToRemove));
    }

    private static List<List<String>> sort(List<String> lineHeader, List<List<String>> table, String header) {
        int indexToCompare = lineHeader.indexOf(header);
        return table.stream().sorted(Comparator.comparing(r -> r.get(indexToCompare))).collect(Collectors.toList());
    }

    private static List<List<String>> filter(List<String> lineHeader, List<List<String>> table, String header, String value) {
        int indexToSearch = lineHeader.indexOf(header);
        List<List<String>> updatedTable = new ArrayList<>();
        for (List<String> currentRow : table) {
            if (currentRow.get(indexToSearch).equals(value)) {
                updatedTable.add(currentRow);
            }
        }
        return updatedTable;
    }
}
