package StacksandQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        fibonacci.push(0l);
        fibonacci.push(1l);

        if(n < 2){
            System.out.println(1);
            return;
        }

        for (int i = 0; i < n; i++) {
            long firstFibonacci = fibonacci.pop();
            long secondFibonacci = fibonacci.pop();

            long sum = firstFibonacci + secondFibonacci;
            fibonacci.push(firstFibonacci);
            fibonacci.push(sum);

        }

        System.out.println(fibonacci.pop());

    }
}
