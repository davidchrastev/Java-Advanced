package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> amountOfPesticide = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int dayCounter = 0;
        int toRemove = 0;
        boolean plantsToRemove = true;


        while (plantsToRemove) {
            toRemove = 0;

            for (int i = 0; i < n - 1; i++) {

                if (amountOfPesticide.get(i) < amountOfPesticide.get(i + 1)) {
                    stack.push(i + 1);
                    toRemove++;
                }
            }
            if (toRemove == 0) {
                plantsToRemove = false;
                continue;
            }

            while (!stack.isEmpty()) {
                int current = stack.pop();
                amountOfPesticide.remove(current);
            }

            n = amountOfPesticide.size();
            dayCounter = dayCounter + 1;
        }
        System.out.println(dayCounter);
    }
}
