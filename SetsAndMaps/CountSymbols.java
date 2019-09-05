package SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            symbols.putIfAbsent(ch, 0);
            symbols.put(ch, symbols.get(ch) + 1);
        }

        for (Map.Entry<Character, Integer> kvp : symbols.entrySet()) {
            System.out.println(String.format("%c: %d time/s", kvp.getKey(), kvp.getValue()));
        }
    }
}
