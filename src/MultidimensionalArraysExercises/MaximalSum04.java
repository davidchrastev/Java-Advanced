package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MaximalSum04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] fillMatrix = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(fillMatrix[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int startIndexRows = 0;
        int startIndexCols = 0;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int current = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        current += matrix[i][j];
                    }
                }

                if (current > maxSum) {
                    maxSum = current;
                    startIndexRows = row;
                    startIndexCols = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);

        printMatrix(matrix, startIndexRows, startIndexCols);
    }

    private static void printMatrix(int[][] matrix, int startIndexRows, int startIndexCols) {
        for (int row = startIndexRows; row < startIndexRows + 3; row++) {
            for (int col = startIndexCols; col < startIndexCols + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
