package DefiningClasses.pokemontrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private static final int DEFAULT_BADGES = 0;

    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = DEFAULT_BADGES;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(String pokemonName, String element, int health) {
        this.pokemons.add(new Pokemon(pokemonName, element, health));
    }

    public void hasElement(String element) {
        if (this.pokemons.stream().anyMatch(p -> p.getElement().equals(element))) {
            this.badges++;
        } else {
            this.pokemons = this.pokemons.stream()
                    .peek(Pokemon::decreaseHealth)
                    .filter(p -> p.getHealth() > 0)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", getName(), getBadges(), getPokemons().size());
    }
}
