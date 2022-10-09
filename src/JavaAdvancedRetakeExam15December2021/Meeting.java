package JavaAdvancedRetakeExam15December2021;

import java.util.*;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(m -> males.push(Integer.parseInt(m)));

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(f -> females.offer(Integer.parseInt(f)));

        int matches = 0;
        boolean removeWoman = false;
        boolean removeMan = false;



            while (!males.isEmpty() && !females.isEmpty()) {
                int currentMale = males.peek();
                int currentFemale = females.peek();

                if (removeMan) {
                    males.pop();
                    continue;
                } else if (removeWoman) {
                    females.poll();
                    continue;
                }


                if (currentMale <= 0) {
                    males.pop();
                    continue;
                }
                if (currentFemale <= 0) {
                    females.poll();
                    continue;
                }

                if (currentMale % 25 == 0) {
                    males.pop();
                    removeMan = true;
                    continue;
                }
                if (currentFemale % 25 == 0) {
                    removeWoman = true;
                    females.poll();
                    continue;
                }

                if (currentFemale == currentMale) {
                    matches++;
                    males.pop();
                    females.poll();
                } else {
                    females.poll();
                    currentMale -= 2;
                    males.pop();
                    males.push(currentMale);

                }
            }


        System.out.println("Matches: " + matches);

        if (!males.isEmpty()) {
            List<String> output = new ArrayList<>();

            while (!males.isEmpty()) {
                String current = males.pop().toString();
                output.add(current);
            }
            System.out.println("Males left: " + (String.join(", ", output)));
        } else {
            System.out.println("Males left: none");
        }
        if (!females.isEmpty()) {
            List<String> output = new ArrayList<>();

            while (!females.isEmpty()) {
                String current = females.poll().toString();
                output.add(current);
            }
            System.out.println("Females left: " + (String.join(", ", output)));
        } else {
            System.out.println("Females left: none");
        }

    }

    private static void checkMatches(ArrayDeque<Integer> males, ArrayDeque<Integer> females, int matches) {
        while (!males.isEmpty() && !females.isEmpty()) {
            int currentMale = males.peek();
            int currentFemale = females.peek();

            if (currentMale <= 0 || currentFemale <= 0) {
                males.pop();
                females.poll();
                continue;
            }

            if (currentMale % 25 == 0) {
                males.pop();
                continue;
            }
            if (currentFemale % 25 == 0) {
                females.poll();
                continue;
            }

            if (currentFemale == currentMale) {
                matches++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                currentMale -= 2;
                males.pop();
                males.push(currentMale);
            }
        }
    }
}
