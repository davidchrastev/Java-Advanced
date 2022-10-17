package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlates = new ArrayDeque<>();
        ArrayDeque<Integer> cars = new ArrayDeque<>();

        String[] input = (scanner.nextLine().split(", "));
        String[] input2 = (scanner.nextLine().split(", "));
        for (String value : input) {
            licensePlates.offer(Integer.parseInt(value));
        }
        for (String s : input2) {
            cars.push(Integer.parseInt(s));
        }
        int days = 0;
        int countRegisteredCars = 0;
        while (!licensePlates.isEmpty() && !cars.isEmpty()) {
            int currentLicencePlate = licensePlates.peek();
            int currentCountCars = cars.peek();

            int currentNumberOfPlate = 0;
            for (int i = 0; i < 1; i++) {
                currentNumberOfPlate = licensePlates.poll();
            }

            int currNumberOfCars = 0;
            for (int i = 0; i < 1; i++) {
                currNumberOfCars = cars.pop();
            }
            if (currentNumberOfPlate > (currNumberOfCars * 2)) {
                licensePlates.addLast(currentNumberOfPlate - (currNumberOfCars * 2));
               countRegisteredCars += currNumberOfCars;
            } else if (currentNumberOfPlate < (currNumberOfCars * 2)) {
                int leftCars = currNumberOfCars - (currentNumberOfPlate / 2);
                cars.addLast(leftCars);

                countRegisteredCars += (currentNumberOfPlate / 2);
            } else {
                countRegisteredCars += currNumberOfCars;
            }

            days++;

        }

        System.out.println(countRegisteredCars + " cars were registered for "+ days + " days!");

        if (cars.isEmpty() && licensePlates.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
        int count = 0;
        if (!licensePlates.isEmpty()) {
            while (!licensePlates.isEmpty()) {
                count += licensePlates.poll();
            }
            System.out.println(count +" license plates remain!");
        }
        int countCars = 0;
        if (!cars.isEmpty()) {
            while (!cars.isEmpty()) {
                countCars += cars.pop();
            }
            System.out.println(countCars + " cars remain without license plates!");
        }


    }
}
