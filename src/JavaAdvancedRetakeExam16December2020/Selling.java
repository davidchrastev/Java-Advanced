package JavaAdvancedRetakeExam16December2020;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                char toPut = currentRow[col].charAt(0);
                matrix[row][col] = toPut;
                if (toPut == 'S') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        int moneys = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[playerRow][playerCol] = '-';
            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
            if (playerRow < 0 || playerRow >= size || playerCol < 0 || playerCol >= size) {
                System.out.println("Bad news, you are out of the bakery.");
                System.out.println("Money: " + moneys);
                printMatrix(matrix);
                return;
            }
            char currentSymbol = matrix[playerRow][playerCol];

            if (Character.isDigit(currentSymbol)) {
                String transferMoney = currentSymbol + "";
                moneys += Integer.parseInt(transferMoney);
            }
            if (matrix[playerRow][playerCol] == 'O') {
                matrix[playerRow][playerCol] = '-';
                int[] newPositions = findOther0(matrix);
                playerRow = newPositions[0];
                playerCol = newPositions[1];
            }

            if (moneys >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                System.out.println("Money: " + moneys);
                matrix[playerRow][playerCol] = 'S';
                printMatrix(matrix);
                return;
            }
            matrix[playerRow][playerCol] = 'S';
        }

    }
    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static int[] findOther0(char[][] matrix) {
        int[] newPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'O') {
                    newPosition[0] = row;
                    newPosition[1] = col;
                }
            }
        }
        return newPosition;
    }
}
