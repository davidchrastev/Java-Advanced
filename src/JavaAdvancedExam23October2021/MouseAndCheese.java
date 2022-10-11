package JavaAdvancedExam23October2021;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parameters = Integer.parseInt(scanner.nextLine());

        char [][] field = new char[parameters][parameters];

        for (int row = 0; row < parameters; row++) {
            field[row] = scanner.nextLine().toCharArray();
        }

        int mouseRow = 0;
        int mouseCol = 0;

        for (int row = 0; row < parameters; row++) {
            for (int col = 0; col < parameters; col++) {
                if (field[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }
        String command = scanner.nextLine();

        int eatenCheeses = 0;

        while (!command.equals("end")) {

            field[mouseRow][mouseCol] = '-';

            switch (command) {
                case "up" -> mouseRow--;
                case "down" -> mouseRow++;
                case "left" -> mouseCol--;
                case "right" -> mouseCol++;
            }

            if (!isMouseInBounds(mouseRow,mouseCol,parameters)) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (field[mouseRow][mouseCol] == 'c') {
                eatenCheeses++;
            }

            if (field[mouseRow][mouseCol] == 'B') {
                continue;
            }

            field[mouseRow][mouseCol] = 'M';

            command = scanner.nextLine();
        }

        output(eatenCheeses);
        printField(field);

    }

    private static void output(int eatenCheeses) {
        if (eatenCheeses >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheeses);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheeses);
        }
    }

    public static void printField(char[][] field) {
        for (char[] currentRow : field) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(currentRow[col]);
            }
            System.out.println();
        }
    }
    public static boolean isMouseInBounds(int row, int col, int parameters) {
        return row < parameters && row >= 0 && col < parameters && col >= 0;
    }

}