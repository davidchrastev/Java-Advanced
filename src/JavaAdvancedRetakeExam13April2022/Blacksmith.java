package JavaAdvancedRetakeExam13April2022;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana" , 0);
        swords.put("Sabre", 0);

        String[] steelInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();

        for (String s : steelInput) {
            steelQueue.offer(Integer.parseInt(s));
        }

        String[] carbonInput = scanner.nextLine().split(" ");
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        for (String s : carbonInput) {
            carbonStack.push(Integer.parseInt(s));
        }

        int countSwords = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int materialNeeded = steelQueue.peek() + carbonStack.peek();
            int currentCarbon = carbonStack.peek();

            if (materialNeeded == 70) {
                int currentValue = swords.get("Gladius");
                swords.put("Gladius", currentValue + 1);
                steelQueue.poll();
                carbonStack.pop();
                countSwords++;
            } else if (materialNeeded == 80) {
                int currentValue = swords.get("Shamshir");
                swords.put("Shamshir", currentValue + 1);
                steelQueue.poll();
                carbonStack.pop();
                countSwords++;
            } else if (materialNeeded == 90) {
                int currentValue = swords.get("Katana");
                swords.put("Katana", currentValue + 1);
                steelQueue.poll();
                carbonStack.pop();
                countSwords++;
            } else if (materialNeeded == 110) {
                int currentValue = swords.get("Sabre");
                swords.put("Sabre", currentValue + 1);
                steelQueue.poll();
                carbonStack.pop();
                countSwords++;
            } else {
                steelQueue.poll();
                currentCarbon += 5;
                carbonStack.pop();
                carbonStack.push(currentCarbon);

            }

        }
        boolean forgeSword = true;

        if (countSwords != 0) {
            System.out.printf("You have forged %d swords.%n", countSwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
            forgeSword = false;
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            ArrayList<String> printSteel = new ArrayList<>();
            while (!steelQueue.isEmpty()) {
                printSteel.add(String.valueOf(steelQueue.poll()));
            }
            System.out.println(String.join(", ", printSteel));
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            ArrayList<String> printCarbon = new ArrayList<>();
            while (!carbonStack.isEmpty()) {
                printCarbon.add(String.valueOf(carbonStack.pop()));
            }
            System.out.println(String.join(", ", printCarbon));
        }

        if (forgeSword) {
            swords.entrySet()
                    .stream()
                    .filter(e -> e.getValue() != 0)
                    .forEach(sword -> System.out.println(sword.getKey() + ": " + sword.getValue()));
        }


    }
}
