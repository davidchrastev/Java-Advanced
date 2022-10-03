package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOperations = Integer.parseInt(scanner.nextLine());
        String text = "";
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < countOperations; i++) {
            String[] command = scanner.nextLine().split("\\s");

            switch (command[0]) {
                case "1":
                    stack.push(text);
                    text += command[1];

                    break;
                case "2":
                    stack.push(text);
                    int index = Integer.parseInt(command[1]);
                    text = text.substring(0,text.length() - index);

                    break;
                case "3":
                    int indexAtPosition = Integer.parseInt(command[1]);
                    System.out.println(text.charAt(indexAtPosition - 1));

                    break;
                case "4":
                    text = stack.pop();
                    break;
            }

        }

    }

}
