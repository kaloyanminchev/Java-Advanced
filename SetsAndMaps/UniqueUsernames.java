package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> usernames = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String name = scanner.nextLine();
            usernames.add(name);
        }

        System.out.println(String.join(System.lineSeparator(), usernames));
    }
}
