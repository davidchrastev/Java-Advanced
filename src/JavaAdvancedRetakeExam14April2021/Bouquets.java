package JavaAdvancedRetakeExam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(t -> tulips.push(Integer.parseInt(t)));
        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(d -> daffodils.offer(Integer.parseInt(d)));
        int bouquet = 0;
        int finalSum = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int currentTulip = tulips.peek();
            int currentDaffodil = daffodils.peek();
            int sum = currentTulip + currentDaffodil;

            while (sum > 15) {
                sum -= 2;
            }

            if (sum == 15) {
                bouquet++;
                tulips.pop();
                daffodils.poll();
            }
            if (sum < 15) {
                tulips.pop();
                daffodils.poll();
                finalSum += sum;
            }

        }
        finalSum /= 15;

        if (finalSum > 0) {
            bouquet += finalSum;
        }

        if (bouquet >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquet);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquet);
        }
    }
}
