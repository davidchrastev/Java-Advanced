package MultidimensionalArraysExercises;

import java.util.Scanner;

public class MatrixofPalindromes02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parameters = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(parameters[0]);
        int cols = Integer.parseInt(parameters[1]);
        String[][] matrix = new String[rows][cols];
        char start = 'a';

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                char middleChar = (char) (start + col);
                String current = "" + start + middleChar + start;
                matrix[row][col] = current;
            }
            start += (char) 1;
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }
}
