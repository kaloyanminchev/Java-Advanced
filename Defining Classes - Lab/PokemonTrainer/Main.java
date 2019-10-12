package DefiningClasses.pokemontrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while (!"Tournament".equals(input = scanner.nextLine())) {

            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            if (!trainers.containsKey(name)) {
                Trainer trainer = new Trainer(name);
                trainers.put(name, trainer);
            }

            trainers.get(name).addPokemon(pokemonName, element, health);
        }

        String secondInput;
        while (!"End".equals(secondInput = scanner.nextLine())) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                entry.getValue().hasElement(secondInput);
            }
        }

        trainers.entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().getBadges() - f.getValue().getBadges())
                .forEach(entry -> System.out.println(entry.getValue().toString()));
    }
}
