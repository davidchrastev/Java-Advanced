package MultidimensionalArraysExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParkingSystem09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }
        Map<Integer, Integer> rowFull = new HashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("stop")) {
            String[] commandParts = command.split(" ");

            int entrancePoint = Integer.parseInt(commandParts[0]);
            int wantedParkingSpotRow = Integer.parseInt(commandParts[1]);
            int wantedParkingSpotCol = Integer.parseInt(commandParts[2]);


            int moves = 0;
            boolean found = false;

            if (matrix[wantedParkingSpotRow][wantedParkingSpotCol] == 0) {
                moves = checkSteps(entrancePoint, wantedParkingSpotRow, wantedParkingSpotCol);
                matrix[wantedParkingSpotRow][wantedParkingSpotCol] = 1;
                found = true;
            } else {
                int range = 1;

                while (!found) {
                    if (wantedParkingSpotCol - range >= 1 && matrix[wantedParkingSpotRow][wantedParkingSpotCol - range] == 0) {
                        moves = checkSteps(entrancePoint, wantedParkingSpotRow, wantedParkingSpotCol - range);
                        found = true;
                        matrix[wantedParkingSpotRow][wantedParkingSpotCol - range] = 1;
                    } else if (wantedParkingSpotCol + range < matrix[wantedParkingSpotRow].length && matrix[wantedParkingSpotRow][wantedParkingSpotCol + range] == 0) {
                        moves = checkSteps(entrancePoint, wantedParkingSpotRow, wantedParkingSpotCol + range);
                        found = true;
                        matrix[wantedParkingSpotRow][wantedParkingSpotCol + range] = 1;
                    }
                    if (wantedParkingSpotCol - range < 1 && wantedParkingSpotCol + range >= matrix[wantedParkingSpotRow].length) {
                        System.out.printf("Row %d full%n", wantedParkingSpotRow);
                        break;
                    }
                    range++;
                }
            }
            if (found) {
                System.out.println(moves);
            }
            command = scanner.nextLine();

        }
    }


    public static boolean check(int[][] matrix, int a, int b) {
        if (matrix[a][b] == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static int checkSteps(int a, int b, int y) {
        return Math.abs(a - b) + y + 1;

    }
    public static boolean isRowFull(Map<Integer,Integer> rowFull, int currentRow, int rows){

        if (rowFull.get(currentRow) == rows - 2) {
            return true;
        } else {
            return false;
        }
    }


}