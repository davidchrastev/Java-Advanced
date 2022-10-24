package ExamPreparationExercise;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parameter = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[parameter][parameter];
        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < parameter; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < parameter; col++) {
                if (currentRow.charAt(col) == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
                matrix[row] = currentRow.toCharArray();
            }
        }
        boolean isOut = false;

        int pollinatedFlowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            matrix[beeRow][beeCol] = '.';

            switch (command) {
                case "up":
                    beeRow--;
                    if (!isBeeOut(beeRow,beeCol,parameter)) {
                        if (matrix[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeRow--;
                            if (matrix[beeRow][beeCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        }
                    } else {
                        System.out.println("The bee got lost!");
                        isOut = true;
                    }
                    break;
                case "down":
                    beeRow++;
                    if (!isBeeOut(beeRow,beeCol,parameter)) {
                        if (matrix[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeRow++;
                            if (matrix[beeRow][beeCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        }
                    } else {
                        System.out.println("The bee got lost!");
                        isOut = true;
                    }
                    break;
                case "left":
                    beeCol--;
                    if (!isBeeOut(beeRow,beeCol,parameter)) {
                        if (matrix[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeCol--;
                            if (matrix[beeRow][beeCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        }
                    } else {
                        System.out.println("The bee got lost!");
                        isOut = true;
                    }
                    break;
                case "right":
                    beeCol++;
                    if (!isBeeOut(beeRow,beeCol,parameter)) {
                        if (matrix[beeRow][beeCol] == 'f') {
                            pollinatedFlowers++;
                        } else if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeCol++;
                            if (matrix[beeRow][beeCol] == 'f') {
                                pollinatedFlowers++;
                            }
                        }
                    } else {
                        System.out.println("The bee got lost!");
                        isOut = true;
                    }
                    break;
            }

            if (isOut) {
                break;
            }


            matrix[beeRow][beeCol] = 'B';


            command = scanner.nextLine();
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5 - pollinatedFlowers);
        }
        printMatrix(matrix);
    }
    public static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean isBeeOut(int beeRow, int beeCol, int parameter) {
        return beeRow >= parameter && beeRow < 0 && beeCol >= parameter && beeCol < 0;
    }
}