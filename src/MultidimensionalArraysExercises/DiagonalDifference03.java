package MultidimensionalArraysExercises;

import java.util.Scanner;

public class DiagonalDifference03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(currentRow[col]);
            }
        }

        int primaryDiagonal = getPrimaryDiagonal(n, matrix);
        int secondaryDiagonal = getSecondaryDiagonal(n, matrix);
        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));

    }

    private static int getSecondaryDiagonal(int n, int[][] matrix) {
        int secondaryDiagonal = 0;
        for (int row = n - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0 ; col--) {
                if (row + col == n - 1) {
                    secondaryDiagonal += matrix[row][col];
                }
            }
        }
        return secondaryDiagonal;
    }

    private static int getPrimaryDiagonal(int n, int[][] matrix) {
        int primaryDiagonal = 0;
        for (int row = 0; row < n; row++) {
            primaryDiagonal += matrix[row][row];
        }
        return primaryDiagonal;
    }
}