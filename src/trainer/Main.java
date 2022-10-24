package trainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, Trainer> participants = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] inputData = input.split("\\s+");
            String trainerName = inputData[0];
            String pokemonName = inputData[1];
            String pokemonElement = inputData[2];
            int pokemonHealth = Integer.parseInt(inputData[3]);
            participants.putIfAbsent(trainerName, new Trainer(trainerName));
            participants.get(trainerName).addPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {

            String element = input;
            participants.values().forEach(t -> {
                if ((t.getPokemons().stream().anyMatch(p -> p.getElement().equals(element)))) {
                    t.awardBadge();
                } else {
                    t.loseRound();
                }
            });
            input = scanner.nextLine();
        }
        participants.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getBadges(), p1.getBadges()))
                .forEach(System.out::println);
    }
}


