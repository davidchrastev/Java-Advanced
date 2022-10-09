package JavaAdvancedExam23October2021;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputIngredients = scanner.nextLine().split(" ");
        String[] inputFreshness = scanner.nextLine().split(" ");

        Map<String, Integer> cocktailsLevels = Map.of(
                "Pear Sour", 150,
                "The Harvest", 250,
                "Apple Hinny", 300,
                "High Fashion", 400
        );

        Map<String, Integer> cocktails = new TreeMap<>();

        ArrayDeque<Integer> bucketsWithIngredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessValues = new ArrayDeque<>();

        for (String ingredient : inputIngredients) {
            bucketsWithIngredients.offer(Integer.parseInt(ingredient));
        }
        for (String freshness : inputFreshness) {
            freshnessValues.push(Integer.parseInt(freshness));
        }

        while (!bucketsWithIngredients.isEmpty() && !freshnessValues.isEmpty()) {

            int currentIngredient = bucketsWithIngredients.peek();
            int currentFreshness = freshnessValues.peek();

            int freshnessLevelNeeded = currentIngredient * currentFreshness;
            String cocktailName = "";

            if (currentIngredient == 0) {
                bucketsWithIngredients.poll();
                continue;
            }

            for (Map.Entry<String, Integer> entry : cocktailsLevels.entrySet()) {
                if (entry.getValue() == freshnessLevelNeeded) {
                    cocktailName = entry.getKey();
                }
            }

            if (cocktailsLevels.containsValue(freshnessLevelNeeded)) {
                if (cocktails.containsKey(cocktailName)) {
                    int newQuantity = cocktails.get(cocktailName) + 1;
                    cocktails.put(cocktailName,newQuantity);
                } else {
                    cocktails.put(cocktailName,1);
                }
                bucketsWithIngredients.poll();
                freshnessValues.pop();
            } else {
                bucketsWithIngredients.poll();
                freshnessValues.pop();
                currentIngredient += 5;
                bucketsWithIngredients.offer(currentIngredient);
            }
        }

        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int ingredientsLeft = bucketsWithIngredients.stream().mapToInt(Integer::intValue).sum();

        if (ingredientsLeft > 0) {
            System.out.printf("Ingredients left: %d%n", ingredientsLeft);
        }

        cocktails.forEach((key, value) -> System.out.printf(" # %s --> %s%n", key, value));
    }
}
