package Exam2019;

import java.util.Scanner;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int parameter = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[parameter][parameter];
        int santaRow = -1;
        int santaCol = -1;
        int countGoodKids = 0;
        for (int i = 0; i < parameter; i++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int j = 0; j < parameter; j++) {
                matrix[i][j] = currentRow[j].charAt(0);
                if (matrix[i][j] == 'S') {
                    santaRow = i;
                    santaCol = j;
                }
                if (matrix[i][j] == 'V') {
                    countGoodKids++;
                }
            }
        }
        String command = scanner.nextLine();
        int goodKids = 0;
        while (!command.equals("Christmas morning")) {
            matrix[santaRow][santaCol] = '-';
            switch (command) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;
            }
            if (matrix[santaRow][santaCol] == 'V') {
                countOfPresents--;
                goodKids++;
            }

            if (matrix[santaRow][santaCol] == 'C') {
                if (santaRow - 1 >= 0) {
                    matrix[santaRow - 1][santaCol] = '-';
                    countOfPresents--;
                }
                if (santaRow + 1 <= parameter) {
                    matrix[santaRow - 1][santaCol] = '-';
                    countOfPresents--;
                }
                if (santaCol- 1 >= 0) {
                    matrix[santaRow][santaCol - 1] = '-';
                    countOfPresents--;
                }
                if (santaCol + 1 <= parameter) {
                    matrix[santaRow][santaCol + 1] = '-';
                    countOfPresents--;
                }
            }
            matrix[santaRow][santaCol] = 'S';
            if (countOfPresents == 0) {
                System.out.println("Santa ran out of presents!");
                break;
            }

            command = scanner.nextLine();
        }
        printMatrix(matrix);
        if (countGoodKids == goodKids) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n",countGoodKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n" , countGoodKids - goodKids);
        }

    }
    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
