package JavaAdvancedExam26June2021;

import java.util.*;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .forEach(e -> tasks.push(Integer.parseInt(e)));
        Arrays.stream(scanner.nextLine().split(" "))
                .forEach(e -> threads.offer(Integer.parseInt(e)));

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());
        List<Integer> threadsOutput = new ArrayList<>();
        int killerThread = 0;

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int currentTask = tasks.peek();
            int currentThread = threads.peek();

            if (currentTask == taskToBeKilled) {
                killerThread = currentThread;
                threadsOutput.addAll(threads);
                break;
            }

            if (currentThread >= currentTask) {
                threads.poll();
                tasks.pop();
            }
            if (currentThread < currentTask) {
                threads.poll();
            }
        }
        System.out.printf("Thread with value %d killed task %d", killerThread,taskToBeKilled);
        System.out.println();
        for (Integer integer : threadsOutput) {
            System.out.print(integer + " ");
        }
    }
}
