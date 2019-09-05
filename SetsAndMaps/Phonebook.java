package SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> listContacts = new HashMap<>();

        String input;
        while (!"search".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0], number = tokens[1];
            listContacts.put(name, number);
        }

        input = "";
        while (!"stop".equals(input = scanner.nextLine())) {
            if (listContacts.containsKey(input)) {
                System.out.println(String.format("%s -> %s", input, listContacts.get(input)));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
