package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().
                        split("\\s")).
                mapToInt(Integer::parseInt).
                toArray();

        int numbersToPush = numArr[0];
        int numbersToPop = numArr[1];
        int numberToSearch = numArr[2];

        String[] numbersToAdd = scanner.nextLine().split("\\s");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
            stack.push(Integer.parseInt(numbersToAdd[i]));
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(numberToSearch)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }

    }
}
