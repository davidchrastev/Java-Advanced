package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s");

            switch (command[0]) {
                case "1" -> stack.push(Integer.parseInt(command[1]));
                case "2" -> stack.pop();
                case "3" -> System.out.println(Collections.max(stack));
            }

        }
    }
}
