package MultidimensionalArraysExercises;

import java.util.Scanner;

public class FilltheMatrix01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[n][n];
        int counter = 0;

        if (type.equals("A")) {
            fillPatternA(n, matrix, counter);
        } else {
            fillPatternB(n, matrix, counter);
        }

        printMatrix(n,matrix);


    }

    private static void printMatrix(int n, int[][] matrix) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillPatternB(int n, int[][] matrix, int counter) {

        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    counter++;
                    matrix[row][col] = counter;

                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    counter++;
                    matrix[row][col] = counter;

                }
            }
        }
    }

    private static void fillPatternA(int n, int[][] matrix, int counter) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                counter++;
                matrix[row][col] = counter;
            }
        }
    }


}