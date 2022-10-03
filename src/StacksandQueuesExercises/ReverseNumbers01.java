package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbers01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArr = Arrays.stream(scanner.nextLine().
                        split(" ")).
                mapToInt(Integer::parseInt).
                toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= numArr.length - 1; i++) {
            int current = numArr[i];
            stack.push(current);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}