package ExercisesDefiningClasses;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> nameAndAge = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] nameAge = scanner.nextLine().split(" ");
            if (Integer.parseInt(nameAge[1]) > 30) {
                Person person = new Person(nameAge[0],Integer.parseInt(nameAge[1]));
                nameAndAge.put(nameAge[0], Integer.parseInt(nameAge[1]));
            }

        }

        nameAndAge.entrySet().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }
}
