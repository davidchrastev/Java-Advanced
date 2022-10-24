package RegularExam;

import java.lang.reflect.Array;
import java.util.*;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> milligramsOfCoffe = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();
        String[] mills = scanner.nextLine().split(",\\s?");
        for (int i = 0; i < mills.length; i++) {
            milligramsOfCoffe.push(Integer.parseInt(mills[i]));
        }
        String[] drinks = scanner.nextLine().split(",\\s?");
        for (int i = 0; i < drinks.length; i++) {
            energyDrinks.offer(Integer.parseInt(drinks[i]));
        }

        int total = 0;

        while (!milligramsOfCoffe.isEmpty() && !energyDrinks.isEmpty()) {
            int milCoffee = milligramsOfCoffe.peek();
            int energy = energyDrinks.peek();
            int sum = milCoffee * energy;

            if (sum + total <= 300) {
                total += sum;
                milligramsOfCoffe.pop();
                energyDrinks.poll();
            } else {
                total -= 30;
                if (total < 0) {
                    total = 0;
                }
                milligramsOfCoffe.pop();
                energyDrinks.poll();
                energyDrinks.offer(energy);
            }

        }
        if (!energyDrinks.isEmpty()) {
            List<String> output = new ArrayList<>();
            while (!energyDrinks.isEmpty()){
              output.add(String.valueOf(energyDrinks.poll()));
            }
            System.out.println("Drinks left: " + String.join(", ",output));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.%n",total);

    }
}
