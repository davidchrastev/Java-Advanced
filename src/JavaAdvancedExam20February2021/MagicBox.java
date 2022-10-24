package JavaAdvancedExam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> firstBox.offer(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> secondBox.push(Integer.parseInt(e)));

        int finalSum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstBoxElement = firstBox.peek();
            int secondBoxElement = secondBox.peek();
            int sum = firstBoxElement + secondBoxElement;

            if (sum % 2 == 0) {
                finalSum += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                secondBox.pop();
                firstBox.offer(secondBoxElement);
            }
        }


        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (finalSum > 90) {
            System.out.println("Wow, your prey was epic! Value: " + finalSum);
        } else {
            System.out.println("Poor prey... Value: " + finalSum);
        }
    }
}
