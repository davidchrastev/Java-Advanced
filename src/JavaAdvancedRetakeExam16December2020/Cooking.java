package JavaAdvancedRetakeExam16December2020;

import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Food	Value needed
//        Bread	25
//        Cake	50
//        Pastry	75
//        Fruit Pie	100
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> liquidsQueue.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> ingredientsStack.push(Integer.parseInt(e)));
        Map<String,Integer> materials = new TreeMap<>();
        materials.put("Bread",0);
        materials.put("Cake",0);
        materials.put("Pastry",0);
        materials.put("Fruit Pie",0);
        int current;

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currentLiquid = liquidsQueue.peek();
            int currentIngredient = ingredientsStack.peek();
            int sum = currentLiquid + currentIngredient;

            if (sum == 25) {
                current = materials.get("Bread");
                materials.put("Bread",current + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 50) {
                current = materials.get("Cake");
                materials.put("Cake",current + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 75) {
                current = materials.get("Pastry");
                materials.put("Pastry",current + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else if (sum == 100) {
                current = materials.get("Fruit Pie");
                materials.put("Fruit Pie",current + 1);
                liquidsQueue.poll();
                ingredientsStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientsStack.pop();
                currentIngredient += 3;
                ingredientsStack.push(currentIngredient);
            }
        }
        int count = 0;
        count = (int) materials.entrySet()
                .stream().filter(e -> e.getValue() > 0)
                .count();
        if (count == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> liquids = new ArrayList<>();
            while (!liquidsQueue.isEmpty()) {
                liquids.add(String.valueOf(liquidsQueue.poll()));
            }
            System.out.println("Liquids left: " + String.join(", ",liquids));
        }
        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> ingredients = new ArrayList<>();
            while (!ingredientsStack.isEmpty()) {
                ingredients.add(String.valueOf(ingredientsStack.pop()));
            }
            System.out.println("Ingredients left: " + String.join(", ", ingredients));
        }
        materials.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
