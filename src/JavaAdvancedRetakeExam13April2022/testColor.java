package JavaAdvancedRetakeExam13April2022;

import java.util.Arrays;
import java.util.Scanner;

public class testColor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[6][6];

        int rowStart = 4;
        int colStart = 4;

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = currentRow;
        }

        printMatrix(matrix);
        int radius = 1;
        boolean nothingToDraw = false;
        boolean down = true;
        boolean up = true;
        boolean left = true;
        boolean right = true;
        while (true) {
            int count = 0;

                    matrix[rowStart][colStart] = 3;

                    if (matrix[rowStart][colStart] != 1) {
                        if (matrix[rowStart + 1][colStart] != 1 && matrix[rowStart + 1][colStart] != 3) {
                            down = true;
                        }

                        if (down) {
                            if (rowStart + 1 <= 6 - 1) {
                                if (matrix[rowStart + 1][colStart] != 1) {
                                    matrix[rowStart + 1][colStart] = 3;
                                    rowStart += 1;
                                    count++;
                                } else {
                                    down = false;
                                }
                            }
                        }
                        if (matrix[rowStart - 1][colStart] != 1 && matrix[rowStart - 1][colStart] != 3) {
                            up = true;
                        }

                        if (up) {
                            if (rowStart - 1 >= 0) {
                                if (matrix[rowStart - 1][colStart] != 1) {
                                    matrix[rowStart - 1][colStart] = 3;
                                    rowStart -= 1;
                                    count++;
                                } else {
                                    up = false;
                                }
                            }
                        }
                        if (matrix[rowStart][colStart + 1] != 1 && matrix[rowStart][colStart + 1] != 3) {
                            right = true;
                        }
                        if (right) {
                            if (colStart + 1 <= 6 - 1) {
                                if (matrix[rowStart][colStart + 1] != 1) {
                                    matrix[rowStart][colStart + 1] = 3;
                                    colStart += 1;
                                    count++;
                                } else {
                                    right = false;
                                }
                            }
                        }
                        if (matrix[rowStart][colStart - 1] != 1 && matrix[rowStart][colStart - 1] != 3) {
                            left = true;
                        }
                        if (left) {
                            if (colStart - 1 >= 0) {
                                if (matrix[rowStart][colStart - radius] != 1) {
                                    matrix[rowStart][colStart - 1] = 3;
                                    colStart -= 1;
                                    count++;
                                } else {
                                    left = false;
                                }
                            }
                        }
                    }


                    if (count == 0) {
                        printMatrix(matrix);
                        nothingToDraw = true;
                        return;
                    }

            radius++;

        }

    }
    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
