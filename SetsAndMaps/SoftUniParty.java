package SetsAndMaps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String guest = "";
        while (!"PARTY".equals(guest = scanner.nextLine())) {
            if (Character.isDigit(guest.charAt(0))) {
                VIP.add(guest);
            } else {
                regular.add(guest);
            }
        }

        while (!"END".equals(guest = scanner.nextLine())) {
            VIP.remove(guest);
            regular.remove(guest);
        }

        System.out.println(VIP.size() + regular.size());
        VIP.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
