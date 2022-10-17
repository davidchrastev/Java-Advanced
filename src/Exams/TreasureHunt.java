package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fieldDimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(fieldDimensions[0]);
        int cols = Integer.parseInt(fieldDimensions[1]);

       char[][] matrix = new char[rows][cols];
        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replace(" ", "").toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'Y') {
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        List<String> commandsToTreasure = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        while (!command.equals("Finish")) {
            commands.add(command);
            command = scanner.nextLine();
        }

        for (int i = 0; i <= commands.size() - 1; i++) {
            String direction = commands.get(i);

            switch (direction) {
                case "up":
                    if (playerRow - 1 >= 0 && matrix[playerRow - 1][playerCol] != 'T') {
                        playerRow--;
                        commandsToTreasure.add(direction);
                    }
                    break;
                case "down":
                    if (playerRow + 1 < rows && matrix[playerRow + 1][playerCol] != 'T') {
                        playerRow++;
                        commandsToTreasure.add(direction);
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0 && matrix[playerRow][playerCol - 1] != 'T') {
                        playerCol--;
                        commandsToTreasure.add(direction);
                    }
                    break;
                case "right":
                    if (playerCol + 1 < cols && matrix[playerRow][playerCol + 1] != 'T') {
                        playerCol++;
                        commandsToTreasure.add(direction);
                    }
                    break;
            }
        }
        if (matrix[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println("The right path is " + String.join(", ",commandsToTreasure));
        } else {
            System.out.println("The map is fake!");
        }

    }
}
