package Exam2019;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> boxValues = new ArrayDeque<>();
        ArrayDeque<Integer> magicValues = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> boxValues.push(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> magicValues.offer(Integer.parseInt(e)));
        System.out.println(boxValues.pop());
        System.out.println(magicValues.poll());

        while (!boxValues.isEmpty() && !magicValues.isEmpty()) {

        }
    }
}
