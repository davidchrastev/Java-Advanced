package DefiningClassesLab;

import java.util.Scanner;

public class Constructors02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");

            ConstructorsClass constructorsClass;
            if (data.length == 1) {
                constructorsClass = new ConstructorsClass(data[0]);
            } else {
                String brand = data[0];
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                constructorsClass = new ConstructorsClass(brand,model,horsePower);

            }
            System.out.println(constructorsClass);
        }
    }
}
