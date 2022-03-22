package P07Google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private final String name;
    private Company company;
    private Car car;
    private final List<Relative> parents;
    private final List<Relative> children;
    private final List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {

        return this.name + "\n" +
                "Company: \n" +
                ((this.company == null) ? "" : this.company.toString() + "\n") +
                "Car:\n" +
                ((this.car == null) ? "" : this.car.toString() + "\n") +
                "Pokemon:\n" +
                ((this.pokemons.isEmpty()) ? "" : this.pokemons
                        .stream().map(Pokemon::toString).collect(Collectors.joining("\n")) + "\n") +
                "Parents: \n" +
                ((this.parents.isEmpty()) ? "" : this.parents
                        .stream().map(Relative::toString).collect(Collectors.joining("\n")) + "\n") +
                "Children: \n" +
                ((this.children.isEmpty()) ? "" : this.children
                        .stream().map(Relative::toString).collect(Collectors.joining("\n")) + "\n");
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }


    public void addParent(Relative relative) {
        this.parents.add(relative);
    }

    public void addChild(Relative relative) {
        this.children.add(relative);
    }
}
