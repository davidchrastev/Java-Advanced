package ExamPreparationExercise;

import java.util.*;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> firstLootBox.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> secondLootBox.push(Integer.parseInt(e)));
        int claimedItems = 0;

        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int firstItem = firstLootBox.peek();
            int secondItem = secondLootBox.peek();
            int sumItems = firstItem + secondItem;

            if (sumItems % 2 == 0) {
                claimedItems += sumItems;
                firstLootBox.poll();
                secondLootBox.pop();
            } else {
                secondLootBox.pop();
                firstLootBox.offer(secondItem);
            }
        }
        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondLootBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems >= 100) {
            System.out.println("Your loot was epic! Value: " + claimedItems);
        } else {
            System.out.println("Your loot was poor... Value: " + claimedItems);
        }

    }
}
