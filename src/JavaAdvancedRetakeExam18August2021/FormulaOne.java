package JavaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parameters = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[parameters][parameters];
        int countCommands = Integer.parseInt(scanner.nextLine());
        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < parameters; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < parameters; col++) {
                field[row][col] = currentRow.charAt(col);

                if (field[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        boolean playerWon = false;

        for (int i = 0; i < countCommands; i++) {
            String command = scanner.nextLine();

            field[playerRow][playerCol] = '.';

            switch (command) {
                case "up" -> {
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = parameters - 1;
                    }
                }
                case "down" -> {
                    playerRow++;
                    if (playerRow == parameters) {
                        playerRow = 0;
                    }
                }
                case "right" -> {
                    playerCol++;
                    if (playerCol == parameters) {
                        playerCol = 0;
                    }
                }
                case "left" -> {
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = parameters - 1;
                    }
                }
            }

            if (field[playerRow][playerCol] == 'B') {
                switch (command) {
                    case "up" -> {
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = parameters - 1;
                        }
                    }
                    case "down" -> {
                        playerRow++;
                        if (playerRow == parameters) {
                            playerRow = 0;
                        }
                    }
                    case "right" -> {
                        playerCol++;
                        if (playerCol == parameters) {
                            playerCol = 0;
                        }
                    }
                    case "left" -> {
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = parameters - 1;
                        }
                    }
                }
            }

            if (field[playerRow][playerCol] == 'T') {
                switch (command) {
                    case "up" -> playerRow++;
                    case "down" -> playerRow--;
                    case "right" -> playerCol--;
                    case "left" -> playerCol++;
                }
            }

            if (field[playerRow][playerCol] == 'F') {
                field[playerRow][playerCol] = 'P';
                playerWon = true;
                break;
            }

            field[playerRow][playerCol] = 'P';
        }

        if (playerWon) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printField(field);

    }
    public static void printField(char[][] field) {
        for (char[] chars : field) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(chars[col]);
            }
            System.out.println();
        }
    }
}
