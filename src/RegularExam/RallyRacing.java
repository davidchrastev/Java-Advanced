package RegularExam;

import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] raceField = new char[size][size];
        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                char currentElement = currentRow[col].charAt(0);
                raceField[row][col] = currentElement;
            }
        }
        int raceCarRow = 0;
        int raceCarCol = 0;
        int carKm = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    raceCarRow--;
                    break;
                case "down":
                    raceCarRow++;
                    break;
                case "left":
                    raceCarCol--;
                    break;
                case "right":
                    raceCarCol++;
                    break;
            }
            if (raceField[raceCarRow][raceCarCol] == '.') {
                carKm += 10;
            }
            if (raceField[raceCarRow][raceCarCol] == 'T') {
                raceField[raceCarRow][raceCarCol] = '.';
                int[] newPosition = findNextT(raceField);
                raceCarRow = newPosition[0];
                raceCarCol = newPosition[1];
                carKm += 30;
            }
            if (raceField[raceCarRow][raceCarCol] == 'F') {
                System.out.printf("Racing car %s finished the stage!%n",racingNumber);
                System.out.printf("Distance covered %d km.%n",carKm + 10);
                raceField[raceCarRow][raceCarCol] = 'C';
                printMatrix(raceField);
                return;
            }
            raceField[raceCarRow][raceCarCol] = '.';
            command = scanner.nextLine();
        }
        raceField[raceCarRow][raceCarCol] = 'C';
        System.out.printf("Racing car %s DNF.%n",racingNumber);
        System.out.printf("Distance covered %d km.%n",carKm);

        printMatrix(raceField);
    }
    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static int[] findNextT(char[][] raceField) {
        int[] newPositions = new int[2];
        for (int row = 0; row < raceField.length; row++) {
            for (int col = 0; col < raceField.length; col++) {
                if (raceField[row][col] == 'T') {
                    newPositions[0] = row;
                    newPositions[1] = col;
                }
            }
        }
        return newPositions;
    }
}
