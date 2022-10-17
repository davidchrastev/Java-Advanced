package JavaAdvancedExam26June2021;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int parameter = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        String[][] matrix = new String[parameter][parameter];
        int neededFood = 0;
        int snakeRow = 0;
        int snakeCol = 0;
        for (int row = 0; row < parameter; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < parameter; col++) {
                matrix[row][col] = currentRow[col];

                if (matrix[row][col].equals("s")) {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (matrix[row][col].equals("f")) {
                    neededFood++;
                }
            }
        }
        int lengthSnake = 1;
        int eatenFood = 0;

        for (int i = 0; i < commands.length; i++) {
            String currentCommand =  commands[i];

            switch (currentCommand) {
                case "up":
                    snakeRow--;
                    if (snakeRow < 0) {
                        snakeRow = parameter - 1;
                    }
                    break;
                case "down":
                    snakeRow++;
                    if (snakeRow == parameter) {
                        snakeRow = 0;
                    }
                    break;
                case "left":
                    snakeCol--;
                    if (snakeCol < 0) {
                        snakeCol = parameter - 1;
                    }
                    break;
                case "right":
                    snakeCol++;
                    if (snakeCol == parameter) {
                        snakeCol = 0;
                    }
                    break;
            }
            if (matrix[snakeRow][snakeCol].equals("f")) {
                matrix[snakeRow][snakeCol] = "*";
                eatenFood++;
                lengthSnake++;
            }
            if (matrix[snakeRow][snakeCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (eatenFood == neededFood) {
                System.out.println("You win! Final python length is " + lengthSnake);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", neededFood - eatenFood);

    }
}
