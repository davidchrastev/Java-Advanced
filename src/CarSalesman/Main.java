package CarSalesman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int countEngines = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();

        for (int i = 0; i < countEngines; i++) {
            String[] data = scanner.nextLine().split(" ");
            String engine = data[0];
            int power = Integer.parseInt(data[1]);
            Engine currentEngine = null;

            switch (data.length) {
                case 4:
                    String displacement = data[2];
                    String efficiency = data[3];
                    currentEngine = new Engine(engine,power,displacement,efficiency);
                    break;
                case 3:
                    String unknown = data[2];
                    if (Character.isLetter(unknown.charAt(0))) {
                        currentEngine = new Engine(engine,power);
                        currentEngine.setEfficiency(unknown);
                    } else {
                        currentEngine = new Engine(engine,power);
                        currentEngine.setDisplacement(unknown);
                    }
                    break;
                case 2:
                    currentEngine = new Engine(engine,power);
                    break;
            }
            engines.put(engine,currentEngine);
        }

        int countCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < countCars; i++) {
            String[] data = scanner.nextLine().split(" ");
            String nameCar = data[0];
            String engineName = data[1];
            Car currentCar = null;
            switch (data.length) {
                case 4:
                    String weight = data[2];
                    String color = data[3];
                    currentCar = new Car(nameCar,engineName,weight,color);
                    break;
                case 3:
                    String unknown = data[2];
                    if (Character.isDigit(unknown.charAt(0))) {
                        currentCar = new Car(nameCar,engineName);
                        currentCar.setWeight(unknown);
                        currentCar.setColor("n/a");

                    } else {
                        currentCar = new Car(nameCar,engineName);
                        currentCar.setColor(unknown);
                        currentCar.setWeight("n/a");
                    }
                    break;
                case 2:
                    currentCar = new Car(nameCar,engineName);
                    currentCar.setWeight("n/a");
                    currentCar.setColor("n/a");
                    break;
            }
            System.out.println(nameCar + ":");
            String engineType = currentCar.getEngine();
            System.out.println(engines.get(engineType).getModel() + ":");
            System.out.println("Power: " + engines.get(engineType).getPower());
            System.out.println("Displacement: " + engines.get(engineType).getDisplacement());
            System.out.println("Efficiency: " + engines.get(engineType).getEfficiency());
            System.out.println("Weight: " + currentCar.getWeight());
            System.out.println("Color: " + currentCar.getColor());
        }
    }
}
