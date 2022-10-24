package JavaAdvancedExam28June2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int snakeRow = -1;
        int snakeCol = -1;
        for (int row = 0; row < size; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                char currentElement = currentRow.charAt(col);
                matrix[row][col] = currentElement;
                if (currentElement == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }
        int eatenFood = 0;
        while (true) {
            String command = scanner.nextLine();
            matrix[snakeRow][snakeCol] = '.';

            switch (command) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }

            if (printIfOutOfBounds(size, matrix, snakeRow, snakeCol, eatenFood)) {
                return;
            }

            if (matrix[snakeRow][snakeCol] == 'B') {
                matrix[snakeRow][snakeCol] = '.';
                int[] newPositions = findNextB(matrix);
                snakeRow = newPositions[0];
                snakeCol = newPositions[1];
            }

            if (matrix[snakeRow][snakeCol] == '*') {
                eatenFood++;
            }
            if (printIfSnakeAteTheFood(matrix, snakeRow, snakeCol, eatenFood)) {
                return;
            }
            matrix[snakeRow][snakeCol] = 'S';

        }

    }

    private static boolean printIfSnakeAteTheFood(char[][] matrix, int snakeRow, int snakeCol, int eatenFood) {
        if (eatenFood >= 10) {
            matrix[snakeRow][snakeCol] = 'S';
            System.out.println("You won! You fed the snake.");
            System.out.println("Food eaten: " + eatenFood);
            printMatrix(matrix);
            return true;
        }
        return false;
    }

    private static boolean printIfOutOfBounds(int size, char[][] matrix, int snakeRow, int snakeCol, int eatenFood) {
        if (snakeRow < 0 || snakeRow >= size || snakeCol < 0 || snakeCol >= size) {
            System.out.println("Game over!");
            System.out.println("Food eaten: " + eatenFood);
            printMatrix(matrix);
            return true;
        }
        return false;
    }

    public static void print() {

    }
    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
    public static int[] findNextB(char[][] matrix) {
        int[] newPosition = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'B') {
                    newPosition[0] = row;
                    newPosition[1] = col;
                    return newPosition;
                }
            }
        }
        return newPosition;
    }
}
