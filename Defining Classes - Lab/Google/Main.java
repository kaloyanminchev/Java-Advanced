package DefiningClasses.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> people = new HashMap<>();

        String input = reader.readLine();
        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");
            String name = tokens[0];

            if (!people.containsKey(name)) {
                Person person = new Person();
                people.put(name, person);
            }

            switch (tokens[1]) {
                case "company":
                    people.get(name).setCompany(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    break;
                case "pokemon":
                    people.get(name).addPokemon(tokens[2], tokens[3]);
                break;
                case "parents":
                    people.get(name).addParents(tokens[2], tokens[3]);
                    break;
                case "children":
                    people.get(name).addChildren(tokens[2], tokens[3]);
                    break;
                case "car":
                    people.get(name).setCar(tokens[2], Integer.parseInt(tokens[3]));
                    break;
            }

            input = reader.readLine();
        }

        String searchName = reader.readLine();
        System.out.println(searchName);
        people.get(searchName).getInfo();
    }
}
