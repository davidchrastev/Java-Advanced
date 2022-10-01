package MultidimensionalArraysExercises;

import java.util.Scanner;

public class Crossfire07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] borders = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(borders[0]);
        int cols = Integer.parseInt(borders[1]);

        String[][] matrix = new String[rows][cols];
        int counter = 1;

        fillMatrix(rows, cols, matrix, counter);



        String input = scanner.nextLine();
        boolean refactor = false;

        while (!input.equals("Nuke it from orbit")) {
            String[] parts = input.split(" ");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            int radius = Integer.parseInt(parts[2]);

            if (matrix[row][col].equals("0")) {
                for (int r = row - radius; r <= row + radius; r++) {
                    if (isInBounds(matrix, r, col + 1)) {
                        matrix[r][col + 1] = "0";
                    }
                }

                for (int c = col - radius; c <= col + radius; c++) {
                    if (isInBounds(matrix, row, c)) {
                        matrix[row][c] = "0";
                    }
                }
            } else {
                for (int r = row - radius; r <= row + radius; r++) {
                    if (isInBounds(matrix, r, col)) {
                        matrix[r][col] = "0";
                    }
                }

                for (int c = col - radius; c <= col + radius; c++) {
                    if (isInBounds(matrix, row, c)) {
                        matrix[row][c] = "0";
                    }
                }
            }

            input = scanner.nextLine();
        }

        printMatrix(rows, cols, matrix);

    }

    private static void printMatrix(int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] != "0") {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int rows, int cols, String[][] matrix, int counter) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter + "";
                counter++;
            }
        }
    }

    private static boolean isInBounds(String[][] matrix, int row, int col) {
        return row >= 0
                && row < matrix.length
                && col >= 0
                && col < matrix[row].length;
    }

}
