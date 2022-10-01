package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixShuffling05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] fillMatrix = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = (fillMatrix[col]);
            }
        }

        String[] input = scanner.nextLine().split("\\s");

        while (!input[0].equals("END")) {

            if (input.length == 5) {
                if (input[0].equals("swap")) {
                    int leftRow = Integer.parseInt(input[1]);
                    int leftCol = Integer.parseInt(input[2]);
                    int rightRow = Integer.parseInt(input[3]);
                    int rightCol = Integer.parseInt(input[4]);
                    if (leftRow >= rows ||
                            leftCol >= cols || rightRow >= rows ||
                            rightCol >= cols) {
                        System.out.println("Invalid input!");
                    } else {
                        String leftElement = matrix[leftRow][leftCol];
                        String rightElement = matrix[rightRow][rightCol];
                        matrix[leftRow][leftCol] = rightElement;
                        matrix[rightRow][rightCol] = leftElement;

                        for (int row = 0; row < rows; row++) {
                            for (int col = 0; col < cols; col++) {
                                System.out.print(matrix[row][col] + " ");
                            }
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine().split("\\s");

        }
    }
}
