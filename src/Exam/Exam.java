package Exam;

import java.lang.reflect.Array;
import java.util.*;

public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Chocolate types	Cacao percentage
//        Milk Chocolate	30
//        Dark Chocolate	50
//        Baking Chocolate	100

//  The first line of input will represent the milk values - doubles, separated by a single space.

    String[] inputMilkValues = scanner.nextLine().split(" ");

    ArrayDeque<Double> milkValues = new ArrayDeque<>();

        for (int i = 0; i < inputMilkValues.length; i++) {
            milkValues.offer(Double.parseDouble(inputMilkValues[i]));
        }

//  On the second line, you will be given the cacao powder values - doubles again, separated by a single space.

        String[] inputCacaoPowder = scanner.nextLine().split(" ");

        ArrayDeque<Double> cacaoPowderValues = new ArrayDeque<>();

        for (int i = 0; i < inputCacaoPowder.length; i++) {
            cacaoPowderValues.push(Double.parseDouble(inputCacaoPowder[i]));
        }

        Map<String, Integer> chocolates = new HashMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        while (!milkValues.isEmpty() && !cacaoPowderValues.isEmpty()) {
            double currentMilk = milkValues.peek();
            double currentCacao = cacaoPowderValues.peek();

            double cacaoPercentage = currentCacao / (currentMilk + currentCacao) * 100;

            if (cacaoPercentage == 30) {
                int currentCountMilkChocolate = chocolates.get("Milk Chocolate");
                chocolates.put("Milk Chocolate", currentCountMilkChocolate + 1);
                milkValues.poll();
                cacaoPowderValues.poll();

            } else if (cacaoPercentage == 50) {
                int currentCountDarkChocolate = chocolates.get("Dark Chocolate");
                chocolates.put("Dark Chocolate", currentCountDarkChocolate + 1);
                milkValues.poll();
                cacaoPowderValues.poll();

            } else if (cacaoPercentage == 100) {
                int currentCountBakingChoco = chocolates.get("Baking Chocolate");
                chocolates.put("Baking Chocolate", currentCountBakingChoco + 1);
                milkValues.poll();
                cacaoPowderValues.poll();
            } else {
                cacaoPowderValues.pop();
                currentMilk += 10;
                milkValues.poll();
                milkValues.offer(currentMilk);
            }
        }
        boolean isChocolateEmpty = false;
        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
                isChocolateEmpty = true;
                break;
            }
        }
        if (!isChocolateEmpty) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }
        chocolates.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(c -> {
                    if (c.getValue() > 0) {
                        System.out.printf("# %s --> %d%n", c.getKey(), c.getValue());
                    }
                });






    }
}
