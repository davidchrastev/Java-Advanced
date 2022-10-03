package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class KAT01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] countLicensePlates = Arrays.stream(scanner.nextLine().
                        split(", ")).
                mapToInt(Integer::parseInt).toArray();

        int[] numberOfCars = Arrays.stream(scanner.nextLine().
                        split(", ")).
                mapToInt(Integer::parseInt).toArray();



        ArrayDeque<Integer> countLicense = new ArrayDeque<>();

        for (int i = 0; i < countLicensePlates.length; i++) {
            countLicense.offer(countLicensePlates[i]);
        }

        ArrayDeque<Integer> countCars = new ArrayDeque<>();


        for (int count = 0; count < numberOfCars.length; count++) {
            countCars.push(numberOfCars[count]);
        }
        int days = 0;
        int registeredCars = 0;


        while (true) {

            if (countCars.isEmpty() || countLicense.isEmpty()) {
                break;
            }

            int currentCars = countCars.pop();
            int currentLicensePlates = countLicense.poll();

            if (currentCars >= currentLicensePlates) {
                int diffCars = currentCars - (currentLicensePlates / 2);
                countCars.offer(diffCars);
                registeredCars += currentCars - diffCars;


            } else if (currentLicensePlates > currentCars) {
                int diffPlates = currentLicensePlates - (currentCars * 2);
                countLicense.offer(diffPlates);
                registeredCars += currentCars;

            }

            days++;
        }

        System.out.println(registeredCars + " cars were registered for " + days + " days!");

        int licensePlates = 0;

        while (!countLicense.isEmpty()) {
            licensePlates += countLicense.poll();
        }
        int carsAll = 0;

        while (!countCars.isEmpty()) {
            carsAll += countCars.pop();
        }

        if (licensePlates > 0) {
            System.out.println(licensePlates + " license plates remain!");
        }
        if (carsAll - registeredCars > 0) {
            System.out.println(carsAll - registeredCars + " cars remain without license plates!");
        }
        if (carsAll == 0 && licensePlates == 0) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }



    }
}
