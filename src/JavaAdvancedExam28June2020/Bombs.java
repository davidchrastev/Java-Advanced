package JavaAdvancedExam28June2020;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(e -> bombEffects.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(e -> bombCasing.push(Integer.parseInt(e)));
        Map<String,Integer> bombs = new TreeMap<>();

        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);
        int count = 0;
        boolean isEnough = false;

        while (!bombEffects.isEmpty() && !bombCasing.isEmpty()) {
            int effect = bombEffects.peek();
            int casing = bombCasing.peek();
            int sum = effect + casing;
            int current = 0;

            if (count == 3) {
                isEnough = true;
                break;
            }

            if (sum == 40) {
                bombEffects.poll();
                bombCasing.pop();
                current = bombs.get("Datura Bombs");
                bombs.put("Datura Bombs", current + 1);
            } else if (sum == 60) {
                bombEffects.poll();
                bombCasing.pop();
                current = bombs.get("Cherry Bombs");
                bombs.put("Cherry Bombs", current + 1);
            } else if (sum == 120) {
                bombEffects.poll();
                bombCasing.pop();
                current = bombs.get("Smoke Decoy Bombs");
                bombs.put("Smoke Decoy Bombs", current + 1);
            } else {
                casing -= 5;
                bombCasing.pop();
                bombCasing.push(casing);
            }

             count = ((int) bombs.entrySet()
                     .stream()
                     .filter(e -> e.getValue() >= 3)
                     .count());
        }
        if (isEnough) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            List<String> bombEffectsOutPut = new ArrayList<>();
            while (!bombEffects.isEmpty()) {
                bombEffectsOutPut.add(bombEffects.poll().toString());
            }
            System.out.println("Bomb Effects: " + String.join(", ",bombEffectsOutPut));
        }
        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            List<String> bombCasingOutPut = new ArrayList<>();
            while (!bombCasing.isEmpty()) {
                bombCasingOutPut.add(bombCasing.pop().toString());
            }
            System.out.println("Bomb Casings: " + String.join(", ",bombCasingOutPut));
        }
        bombs.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
