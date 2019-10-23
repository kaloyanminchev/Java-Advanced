package exams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] garden = new String[size][];
        for (int r = 0; r < garden.length; r++) {
            garden[r] = scanner.nextLine().split("\\s+");
        }

        Map<String, Integer> vegetables = new LinkedHashMap<>();
        vegetables.put("Carrots", 0);
        vegetables.put("Potatoes", 0);
        vegetables.put("Lettuce", 0);

        int countHarmedVegies = 0;

        String input = scanner.nextLine();
        while (!"End of Harvest".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            if ("Harvest".equals(command)) {
                if (exists(row, col, garden)) {
                    String currentSymbol = garden[row][col];
                    switch (currentSymbol) {
                        case "C":
                            vegetables.put("Carrots", vegetables.get("Carrots") + 1);
                            break;
                        case "P":
                            vegetables.put("Potatoes", vegetables.get("Potatoes") + 1);
                            break;
                        case "L":
                            vegetables.put("Lettuce", vegetables.get("Lettuce") + 1);
                            break;
                    }
                    garden[row][col] = " ";
                }
            } else if ("Mole".equals(command)) {
                String direction = tokens[3];
                if (!exists(row, col, garden)) {
                    input = scanner.nextLine();
                    continue;
                }

                if (isNotBlank(garden, row, col)) {
                    garden[row][col] = " ";
                    countHarmedVegies++;
                }

                switch (direction) {
                    case "up":
                        while (row - 2 >= 0) {
                            row -= 2;
                            if (isNotBlank(garden, row, col)) {
                                garden[row][col] = " ";
                                countHarmedVegies++;
                            }
                        }
                        break;
                    case "down":
                        while (row + 2 < garden.length) {
                            row += 2;
                            if (isNotBlank(garden, row, col)) {
                                garden[row][col] = " ";
                                countHarmedVegies++;
                            }
                        }
                        break;
                    case "left":
                        while (col - 2 >= 0) {
                            col -= 2;
                            if (isNotBlank(garden, row, col)) {
                                garden[row][col] = " ";
                                countHarmedVegies++;
                            }
                        }
                        break;
                    case "right":
                        while (col + 2 < garden[row].length) {
                            col += 2;
                            if (isNotBlank(garden, row, col)) {
                                garden[row][col] = " ";
                                countHarmedVegies++;
                            }
                        }
                        break;
                }
            }

            input = scanner.nextLine();
        }

        printGarden(garden);
        vegetables.forEach((veg, count) -> System.out.println(veg + ": " + count));
        System.out.println("Harmed vegetables: " + countHarmedVegies);
    }

    private static boolean isNotBlank(String[][] garden, int row, int col) {
        return !garden[row][col].equals(" ");
    }

    private static boolean exists(int row, int col, String[][] garden) {
        return row >= 0 && row < garden.length && col >= 0 && col < garden[row].length;
    }

    private static void printGarden(String[][] garden) {
        for (int r = 0; r < garden.length; r++) {
            for (int c = 0; c < garden[r].length; c++) {
                System.out.print(garden[r][c] + " ");
            }
            System.out.println();
        }
    }
}
