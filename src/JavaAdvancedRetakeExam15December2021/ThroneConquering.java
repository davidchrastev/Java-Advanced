package JavaAdvancedRetakeExam15December2021;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energyParis = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());
        char [][] battleField = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            battleField[row] = scanner.nextLine().toCharArray();
        }

        int rowParis = 0;
        int colParis = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < battleField[row].length; col++) {
                if (battleField[row][col] == 'P') {
                    rowParis = row;
                    colParis = col;
                }
            }
        }



        while (true) {
            String command = scanner.nextLine();

            String direction = command.split(" ")[0];
            int spartanRow = Integer.parseInt(command.split(" ")[1]);
            int spartanCol = Integer.parseInt(command.split(" ")[2]);

            battleField[rowParis][colParis] = '-';
            battleField[spartanRow][spartanCol] = 'S';


            switch (direction) {
                case "up":
                    if (rowParis - 1 >= 0) {
                        rowParis--;
                    }
                    break;
                case "down":
                    if (rowParis + 1 < battleField.length) {
                        rowParis++;
                    }
                    break;
                case "left":
                    if (colParis - 1 >= 0) {
                        colParis--;
                    }
                    break;
                case "right":
                    if(colParis + 1 < battleField.length) {
                        colParis++;
                    }

                    break;
            }
            energyParis--;

            if (energyParis <= 0) {
                parisIsDead(battleField, rowParis, colParis);
                return;
            }

            if (battleField[rowParis][colParis] == 'S') {
                energyParis -= 2;

                if (energyParis <= 0) {
                    parisIsDead(battleField, rowParis, colParis);
                    return;
                } else {
                    battleField[rowParis][colParis] = '-';
                }

            } else if (battleField[rowParis][colParis] == 'H') {

                battleField[rowParis][colParis] = '-';

                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energyParis);

                printField(battleField);
                return;
            }

        }

    }
    public static void printField(char[][] battleField) {
        for (char[] currentElement : battleField) {
            for (int col = 0; col < battleField.length; col++) {
                System.out.print(currentElement[col]);
            }
            System.out.println();
        }
    }

    public static void parisIsDead(char[][] field, int parisRow, int parisCol) {
        field[parisRow][parisCol] = 'X';
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        printField(field);
    }

}