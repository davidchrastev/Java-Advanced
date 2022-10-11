package JavaAdvancedExam19February2022;

import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];
        int[] whitePosition = new int[2];
        int[] blackPosition = new int[2];

        fill(scanner, chessBoard, whitePosition, blackPosition);

        int whiteRow = whitePosition[0];
        int whiteCol = whitePosition[1];
        int blackRow = blackPosition[0];
        int blackCol = blackPosition[1];

        while (blackRow != 7 && whiteRow != 0) {
            if (checkCaptureWhite(whiteRow,whiteCol,blackRow,blackCol)) {
                System.out.println("Game over! White capture on " + coordinates(blackRow,blackCol) + ".");

                break;
            }
            whiteRow--;
            if (checkCaptureBlack(whiteRow,whiteCol,blackRow,blackCol)) {
                System.out.println("Game over! Black capture on " + coordinates(whiteRow,whiteCol) + ".");

                break;
            }
            blackRow++;
        }

        if (whiteRow == 0) {
            System.out.println("Game over! White pawn is promoted to a queen at " + coordinates(whiteRow,whiteCol) + ".");
        }
        if (blackRow == 7) {
            System.out.println("Game over! Black pawn is promoted to a queen at " + coordinates(blackRow,blackCol) + ".");
        }
    }
    private static boolean checkCaptureWhite(int whiteRow,int whiteCol, int blackRow, int blackCol) {

        if (whiteRow - 1 == blackRow && (whiteCol - 1 == blackCol || whiteCol + 1 == blackCol)) {
            return true;
        } else {
            return false;
        }

    }
    private static boolean checkCaptureBlack(int whiteRow,int whiteCol, int blackRow, int blackCol) {

        if (whiteRow == blackRow + 1 && (whiteCol == blackCol + 1 || whiteCol == blackCol - 1)) {
            return true;
        } else {
            return false;
        }

    }

    private static void fill(Scanner scanner, char[][] chessBoard, int[] whitePosition, int[] blackPosition) {
        for (int row = 0; row < chessBoard.length; row++) {
            String currentRow = scanner.nextLine();
            for (int col = 0; col < chessBoard.length; col++) {
                char currentChar = currentRow.charAt(col);
                chessBoard[row][col] = currentChar;
                if (currentChar == 'w') {
                    whitePosition[0] = row;
                    whitePosition[1] = col;
                }
                if (currentChar == 'b') {
                    blackPosition[0] = row;
                    blackPosition[1] = col;
                }

            }
        }
    }
    public static String coordinates(int row, int col) {
        char[] c = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] r = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c[col]).append(r[row]);
        return stringBuilder.toString();
    }
}
