package JavaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int field = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[field][field];
        int[] armyPosition = new int[2];

        fillMatrix(scanner, field, matrix, armyPosition);
        int row = armyPosition[0];
        int col = armyPosition[1];
        boolean isOut = false;
        int money = 0;
        boolean enoughMoney = false;


        while (!enoughMoney) {
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (!validIndex(row,col,field)) {
                isOut = true;
            }

            if (isOut) {
                System.out.println("I do not need more swords!");
                break;
            }

            char currentPosition = matrix[row][col];

            money = getMoney(matrix, row, col, money, currentPosition);

            if (currentPosition == 'M') {
                matrix[row][col] = '-';
                armyPosition[0] = row;
                armyPosition[1] = col;
                goToMirrorM(matrix,armyPosition);
                row = armyPosition[0];
                col = armyPosition[1];
                matrix[row][col] = '-';
            }


            if (money >= 65) {
                enoughMoney = true;
            }


        }


        if (money >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
            matrix[row][col] = 'A';
        }

        System.out.printf("The king paid %d gold coins.%n",money);

        printMatrix(matrix);

    }

    private static int getMoney(char[][] matrix, int row, int col, int money, char currentPosition) {
        if (Character.isDigit(currentPosition)) {
            money += Character.getNumericValue(currentPosition);
            matrix[row][col] = '-';
        }
        return money;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int field, char[][] matrix, int[] armyPosition) {
        for (int row = 0; row < field; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < field; col++) {
                char currentChar = currentRow.charAt(col);
                matrix[row][col] = currentChar;
                if (matrix[row][col] == ('A')) {
                    matrix[row][col] = '-';
                    armyPosition[0] = row;
                    armyPosition[1] = col;
                }
            }
        }
    }
    public static boolean validIndex(int row,int col,int field) {
        return (row < field && row >= 0 && col < field && col >= 0);
    }

    public static int[] goToMirrorM(char[][] matrix,int[] playerPosition) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == 'M') {
                    playerPosition[0] = r;
                    playerPosition[1]= c;
                    break;
                }
            }
        }
        return playerPosition;
    }
}
