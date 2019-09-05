package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String email = scanner.nextLine();

            if (!email.toLowerCase().endsWith("us")
                    && !email.toLowerCase().endsWith("uk")
                    && !email.toLowerCase().endsWith("com")) {
                emails.putIfAbsent(input, email);
            }

            input = scanner.nextLine();
        }

        emails.forEach((key, value) -> System.out.printf("%s -> %s\n", key, value));
    }
}
