package DefiningClassesLab;

import java.util.Scanner;

public class DemoInOOP {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carParts = scanner.nextLine().split(" ");
            CarDemo carDemo = new CarDemo(carParts[0], carParts[1], Integer.parseInt(carParts[2]));

            System.out.println(carDemo);
        }

    }
}
