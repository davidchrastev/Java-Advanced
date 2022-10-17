package JavaAdvancedRetakeExam14April2021;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parameter = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[parameter][parameter];
        int chefRow = -1;
        int chefCol = -1;
        int countDollars = 0;
        for (int row = 0; row < parameter; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < parameter; col++) {
                char currentElement = currentRow.charAt(col);
                matrix[row][col] = currentElement;

                if (currentElement == 'S') {
                    chefRow = row;
                    chefCol = col;
                }
            }
        }
        boolean isOut = false;

        while (true) {
            String command = scanner.nextLine();

            matrix[chefRow][chefCol] = '-';
            switch (command) {
                case "up":
                    chefRow--;
                    if (isOutOfBounds(parameter,chefRow)) {
                        isOut = true;
                    }
                    break;
                case "down":
                    chefRow++;
                    if (isOutOfBounds(parameter,chefRow)) {
                        isOut = true;
                    }
                    break;
                case "left":
                    chefCol--;
                    if (isOutOfBounds(parameter,chefCol)) {
                        isOut = true;
                    }
                    break;
                case "right":
                    chefCol++;
                    if (isOutOfBounds(parameter,chefCol)) {
                        isOut = true;
                    }
                    break;
            }

            if (isOut) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            char currentTurn = matrix[chefRow][chefCol];

            if (Character.isDigit(currentTurn)) {
                String digit = currentTurn + "";
                countDollars += Integer.parseInt(digit);
            }
            if (currentTurn == 'P') {
                matrix[chefRow][chefCol] = '-';
                int[] newPositions = findNextPillar(matrix,chefRow,chefCol);
                chefRow = newPositions[0];
                chefCol = newPositions[1];
            }

            matrix[chefRow][chefCol] = 'S';

            if (countDollars >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }

        }
        System.out.println("Money: " + countDollars);
        printMatrix(matrix);
    }
    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(chars[col]);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBounds(int parameter,int move) {
        return move >= parameter || move < 0 ;
    }

    private static int[] findNextPillar(char[][] matrix,int r, int c) {
        int[] rowAndCol = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == 'P') {
                    rowAndCol[0] = row;
                    rowAndCol[1] = col;
                }
            }
        }
        return rowAndCol;
    }
}
