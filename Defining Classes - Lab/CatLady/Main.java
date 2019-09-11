package Practice.CatLady;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Cat> cats = new HashMap<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {

            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double specialValue = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, specialValue);
                    break;
                case "Cymric":
                    cat = new Cymric(name, specialValue);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, specialValue);
                    break;
            }

            cats.putIfAbsent(name, cat);
        }

        String nameCat = scanner.nextLine();
        System.out.println(cats.get(nameCat).toString());
    }
}
