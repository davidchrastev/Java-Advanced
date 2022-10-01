package StacksandQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();

        String command = scanner.nextLine();
        String currentUrl = null;

        while (!command.equals("Home")) {

            if (command.equals("back")) {
                if (urls.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = urls.pop();
                }
            } else {
                if (currentUrl != null) {
                    urls.push(currentUrl);
                }

                currentUrl = command;
            }


            System.out.println(currentUrl);


            command = scanner.nextLine();
        }
    }
}
