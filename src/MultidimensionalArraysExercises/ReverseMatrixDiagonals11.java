package MultidimensionalArraysExercises;

import java.util.Scanner;

public class ReverseMatrixDiagonals11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {
            String[] elementToPut = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(elementToPut[col]);
            }
        }

        for (int col = cols - 1; col >= 0; col--) {
            int printRow = rows - 1;

            for (int printCol = col; printCol < cols && printRow >= 0; printCol++) {
                System.out.print(matrix[printRow][printCol] + " ");
                printRow--;
            }
            System.out.println();
        }

        if (rows >= 2) {
            for (int row = rows - 2; row >= 0; row--) {
                int printRow = row;
                for (int col = 0; col <= row && col < cols; col++) {
                    System.out.print(matrix[printRow][col] + " ");
                    printRow--;
                }
                System.out.println();
            }
        }





    }
}
