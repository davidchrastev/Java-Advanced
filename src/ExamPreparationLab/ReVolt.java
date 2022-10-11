package ExamPreparationLab;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < n; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < n; col++) {
                matrix[row][col] = currentRow.charAt(col);

                if (matrix[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        boolean playerWon = false;
        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();
            matrix[playerRow][playerCol] = '-';

            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = n - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow == n) {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = n - 1;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol == n) {
                        playerCol = 0;
                    }
                    break;
            }

            if (matrix[playerRow][playerCol] == 'B') {
                switch (command) {
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = n - 1;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow == n) {
                            playerRow = 0;
                        }
                        break;
                    case "right":
                        playerCol++;
                        if (playerCol == n) {
                            playerCol = 0;
                        }
                        break;
                    case "left":
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = n - 1;
                        }
                        break;
                }
            }
            if (matrix[playerRow][playerCol] == 'T') {
                switch (command) {
                    case "up":
                        playerRow++;
                        break;
                    case "down":
                        playerRow--;
                        break;
                    case "right":
                        playerCol--;
                        break;
                    case "left":
                        playerCol++;
                        break;
                }
            }
            if (matrix[playerRow][playerCol] == 'F') {
                matrix[playerRow][playerCol] = 'f';
                System.out.println("Player won!");
                printMatrix(matrix);
                return;
            }
            matrix[playerRow][playerCol] = 'f';

        }
        System.out.println("Player lost!");
        printMatrix(matrix);
    }
    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
