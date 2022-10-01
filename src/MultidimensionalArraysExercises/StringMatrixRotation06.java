package MultidimensionalArraysExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class StringMatrixRotation06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        input = input.substring(7, input.length() - 1);

        int rotation = Integer.parseInt(input);
        int angleOfRotation = rotation % 360;

        input = scanner.nextLine();
        ArrayDeque<String> words = new ArrayDeque<>();

        int cols = getCols(scanner, input, words);
        int rows = words.size();

        char[][] matrix = new char[rows][cols];

        fillMatrix(words, cols, rows, matrix);

        printAngleOfRotation(angleOfRotation, cols, rows, matrix);

    }

    private static void printAngleOfRotation(int angleOfRotation, int cols, int rows, char[][] matrix) {
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }


    private static void fillMatrix(ArrayDeque<String> words, int cols, int rows, char[][] matrix) {
        String currentWord = words.poll();
        while (!words.isEmpty()) {

            for (int row = 0; row < rows; row++) {
                char[] currentWordSymbols = currentWord.toCharArray();
                for (int col = 0; col < cols; col++) {
                    if (col > currentWordSymbols.length - 1) {
                        matrix[row][col] += ' ';
                    } else {
                        matrix[row][col] = currentWordSymbols[col];
                    }
                }
                currentWord = words.poll();
            }
        }
    }

    private static int getCols(Scanner scanner, String input, ArrayDeque<String> words) {
        int cols = Integer.MIN_VALUE;
        while (!input.equals("END")) {
            if (input.length() > cols) {
                cols = input.length();
            }
            words.offer(input);

            input = scanner.nextLine();
        }
        return cols;
    }


}
