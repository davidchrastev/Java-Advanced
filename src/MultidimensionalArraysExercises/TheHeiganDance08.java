package MultidimensionalArraysExercises;

import java.util.Scanner;

public class TheHeiganDance08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] heiganChambers = new String[15][15];

        int playerHealth = 18500;
        double heiganHealth = 3000000;

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        heiganChambers[7][7] = "startPosition";
        int[] playerPosition = new int[2];
        playerPosition[0] = 7;
        playerPosition[1] = 7;
        boolean isInCloud = false;

        String killedBy = null;

        while (playerHealth > 0) {

            heiganHealth -= damageToHeigan;

            if (isInCloud) {
                playerHealth -= 3500;
                isInCloud = false;
            }

            if (playerHealth <= 0) {
                killedBy = "Plague Cloud";
                break;
            }

            if (heiganHealth <= 0) {
                break;
            }

            String[] tokens = scanner.nextLine().split("\\s+");

            String spell = tokens[0];
            int hitRow = Integer.parseInt(tokens[1]);
            int hitCol = Integer.parseInt(tokens[2]);
            boolean isPlayerDamaged = checkPlayerIsHit(playerPosition[0],playerPosition[1], hitRow, hitCol);

            int damage = 0;
            if (isPlayerDamaged) {

                if (spell.equals("Cloud")) {
                    damage = 3500;
                    killedBy = "Plague Cloud";
                } else {
                    damage = 6000;
                    killedBy = "Eruption";
                }
                boolean canMove = playerCanMoveAndPlayer(playerPosition, hitRow, hitCol);

                if (!canMove) {
                    playerHealth -= damage;
                    if (spell.equals("Cloud")) {
                        isInCloud = true;
                    }
                }
            }

        }


        if (heiganHealth > 0) {
            System.out.printf("Heigan: %.2f%n",heiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", killedBy);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }
        System.out.println(String.format("Final position: %d, %d", playerPosition[0],playerPosition[1]));
    }


    private static boolean playerCanMoveAndPlayer(int[] playerPosition, int hitRow, int hitCol) {
        boolean canMove = false;
        int r = playerPosition[0];
        int c = playerPosition[1];

        if (isInBounds(r - 1, c) && !checkPlayerIsHit(r - 1,c,hitRow,hitCol)) {
            r--;
            canMove = true;
        } else if (isInBounds(r, c + 1) && !checkPlayerIsHit(r, c + 1, hitRow, hitCol)) {
            c++;
            canMove = true;
        } else if (isInBounds(r + 1, c) && !checkPlayerIsHit(r + 1, c, hitRow, hitCol)) {
            r++;
            canMove = true;
        } else if (isInBounds(r, c - 1) && !checkPlayerIsHit(r, c - 1, hitRow, hitCol)) {
            c--;
            canMove = true;
        }

        playerPosition[0] = r;
        playerPosition[1] = c;

        return canMove;
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < 15 && c >= 0 && c < 15;
    }


    private static boolean checkPlayerIsHit(int r,int c, int hitRow, int hitCol) {
        return r >= hitRow - 1 &&
                r <= hitRow + 1 &&
                c >= hitCol - 1 &&
                c <= hitCol + 1;
    }
}
