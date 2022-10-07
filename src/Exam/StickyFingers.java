package Exam;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int field = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        String[][] matrix = new String[field][field];
        int[] playerPosition = new int[2];

        for (int row = 0; row < field; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < field; col++) {
                if (currentRow[col].equals("D")) {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                }
                matrix[row][col] = currentRow[col];
            }
        }
        matrix[playerPosition[0]][playerPosition[1]] = "+";
        int rowPosition = playerPosition[0];
        int colPosition = playerPosition[1];

        int totalMoney = 0;
        boolean caught = false;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            switch (command) {
                case "up":
                    if (rowPosition - 1 >= 0) {
                        matrix[rowPosition][colPosition] = "+";
                        rowPosition--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }

                    break;
                case "right":
                    if (colPosition + 1 < field) {
                        matrix[rowPosition][colPosition] = "+";
                        colPosition++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (colPosition - 1 >= 0) {
                        matrix[rowPosition][colPosition] = "+";
                        colPosition--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (rowPosition + 1 < field) {
                        matrix[rowPosition][colPosition] = "+";
                        rowPosition++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
            if (matrix[rowPosition][colPosition].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                matrix[rowPosition][colPosition] = "#";
                caught = true;
                break;
            }
            if (matrix[rowPosition][colPosition].equals("$")) {
                System.out.printf("You successfully stole %d$.%n", rowPosition * colPosition);
                totalMoney += rowPosition * colPosition;

            }
            matrix[rowPosition][colPosition] = "D";

            playerPosition[0] = rowPosition;
            playerPosition[1] = colPosition;
        }
        if (!caught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.join(" ",matrix[i]));
        }
    }
}
