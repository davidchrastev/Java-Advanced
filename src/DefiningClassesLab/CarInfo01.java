package DefiningClassesLab;

import java.util.Scanner;

public class CarInfo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

             CarInfoClass carInfoClass = new CarInfoClass(data[0],data[1],Integer.parseInt(data[2]));

            System.out.println(carInfoClass.toString());
        }


    }
}
