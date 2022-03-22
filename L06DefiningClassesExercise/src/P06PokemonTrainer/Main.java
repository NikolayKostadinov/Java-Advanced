package P06PokemonTrainer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, Trainer> trainers = readTrainers(scan);
        playTheGame(scan, trainers);

        trainers
                .values()
                .stream()
                .sorted((t1,t2)->t2.getNumberOfBadges() - t1.getNumberOfBadges())
                .forEach(System.out::println);
    }

    private static void playTheGame(Scanner scan, Map<String, Trainer> trainers) {
        String command = scan.nextLine();
        while (!"End".equals(command)) {
            for (Trainer trainer : trainers.values()) {
                trainer.executeCommand(command);
            }
            command = scan.nextLine();
        }
    }

    private static Map<String, Trainer> readTrainers(Scanner scan) {
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!"Tournament".equals(command)) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(pokemon);
            command = scan.nextLine();
        }

        return trainers;
    }
}
