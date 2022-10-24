package JavaAdvancedExam20February2021;

import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        int countBombs = 0;
        int positionRow = -1;
        int positonCol = -1;

        String[][] matrix = new String[size][size];

        for (int row = 0; row < size; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                String currentElement = currentRow[col];
                matrix[row][col] = currentElement;
                if (currentElement.equals("s")) {
                    positionRow = row;
                    positonCol = col;
                }
                if (currentElement.equals("B")) {
                    countBombs++;
                }
            }
        }
        int bombs = 0;
        for (int i = 0; i <= commands.length - 1; i++) {
            String command = commands[i];

            switch (command) {
                case "up":
                    if (positionRow - 1 >= 0) {
                        positionRow--;
                    }
                    break;
                case "down":
                    if (positionRow + 1 <= size - 1) {
                        positionRow++;
                    }
                    break;
                case "left":
                    if (positonCol - 1 >= 0) {
                        positonCol--;
                    }
                    break;
                case "right":
                    if (positonCol + 1 <= size - 1) {
                        positonCol++;
                    }
                    break;
            }
            if (matrix[positionRow][positonCol].equals("e")) {
                System.out.printf("END! %d bombs left on the field%n", countBombs - bombs);
                return;
            }

            if (matrix[positionRow][positonCol].equals("B")) {
                matrix[positionRow][positonCol] = "+";
                System.out.println("You found a bomb!");
                bombs++;
                if (countBombs == bombs) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n",countBombs - bombs,positionRow,positonCol);

    }
}
