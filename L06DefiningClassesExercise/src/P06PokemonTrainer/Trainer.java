package P06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static final int DAMAGE = 10;
    private String name;
    private int numberOfBadges;
    List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void executeCommand(String element) {
        if (this.pokemons.stream().anyMatch(p -> p.getElement().equals(element))) {
            numberOfBadges++;
        } else {
            for (int i = this.pokemons.size() - 1; i >= 0; i--) {
                int resultHealth = this.pokemons.get(i).getHealth() - DAMAGE;
                if (resultHealth > 0) {
                    this.pokemons.get(i).setHealth(resultHealth);
                } else {
                    this.pokemons.remove(i);
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
