package JavaAdvancedRetakeExam18August2021;

import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputLiquids = scanner.nextLine().split(" ");
        String[] inputIngredients = scanner.nextLine().split(" ");

        Map<String, Integer> foodAndValueNeeded = Map.of(
                "Biscuit", 25,
                "Cake", 50,
                "Pastry", 75,
                "Pie", 100
        );

        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (String liquid : inputLiquids) {
            liquids.offer(Integer.parseInt(liquid));
        }
        for (String ingredient : inputIngredients) {
            ingredients.push(Integer.parseInt(ingredient));
        }

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.peek();
            int currentIngredient = ingredients.peek();
            int sum = currentIngredient + currentLiquid;
            String foodName = "";

            foodName = getFoodName(foodAndValueNeeded, sum, foodName);

            currentState(foodAndValueNeeded, food, liquids, ingredients, currentIngredient, sum, foodName);
        }

        foodCount(food);
        ingredientsOutput(liquids);
        outputIngredients(ingredients);

        food.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static void foodCount(Map<String, Integer> food) {
        Map<String, Integer> filtered = new TreeMap<>();

        food.entrySet()
                .stream()
                .filter(e -> e.getValue() != 0).forEach(e -> filtered.put(e.getKey(), e.getValue()));

        if (filtered.size() < 4) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }
    }

    private static void ingredientsOutput(ArrayDeque<Integer> liquids) {
        List<String> outPutLiquids = new ArrayList<>();
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            while (!liquids.isEmpty()) {
                outPutLiquids.add(String.valueOf(liquids.poll()));
            }
            System.out.println("Liquids left: " + String.join(", ", outPutLiquids));
        }
    }

    private static void outputIngredients(ArrayDeque<Integer> ingredients) {
        List<String> outPutIngredients = new ArrayList<>();
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            while (!ingredients.isEmpty()) {
            outPutIngredients.add(String.valueOf(ingredients.pop()));
        }
            System.out.println("Ingredients left: " + String.join(", ", outPutIngredients));
        }
    }

    private static void currentState(Map<String, Integer> foodAndValueNeeded, Map<String, Integer> food, ArrayDeque<Integer> liquids, ArrayDeque<Integer> ingredients, int currentIngredient, int sum, String foodName) {
        if (foodAndValueNeeded.containsValue(sum)) {
            int newQuantity = food.get(foodName) + 1;
            food.put(foodName, newQuantity);
            liquids.poll();
            ingredients.pop();
        } else {
            liquids.poll();
            ingredients.pop();
            currentIngredient += 3;
            ingredients.push(currentIngredient);
        }
    }

    private static String getFoodName(Map<String, Integer> foodAndValueNeeded, int sum, String foodName) {
        for (Map.Entry<String, Integer> entry : foodAndValueNeeded.entrySet()) {
            if (entry.getValue() == sum) {
                foodName = entry.getKey();
            }
        }
        return foodName;
    }
}
