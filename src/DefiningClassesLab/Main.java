package DefiningClassesLab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Car car = new Car();

        for (int i = 0; i < n; i++) {
            String[] carParts = scanner.nextLine().split(" ");
            car.setBrand(carParts[0]);
            car.setModel(carParts[1]);
            car.setHorsePower(Integer.parseInt(carParts[2]));

            System.out.print(car.toString());
        }

    }
}
