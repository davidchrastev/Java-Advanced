package Project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bottom bottom = new Bottom();
        Items items = new Items();
        Field field = new Field();
        System.out.println("Hello summoner welcome to the Summoners Rift");
        System.out.println("Top,Mid,Jungle,Adc");
        String answer = scanner.nextLine();
        System.out.println("You chose " + answer);
        System.out.println("Your options:");
        bottom.adcs();
        System.out.println();
        System.out.println("Write 1, 2, 3 for the champ you want to play with");
        answer = scanner.nextLine();
        System.out.println("You picked " + bottom.getChamp(Integer.parseInt(answer)));
        System.out.printf("She has %d attack damage%n",bottom.getAd());
        System.out.println();
        System.out.println("Here are the rules you are T J M or B");
        System.out.println("You need to get to the F on the other side");
        System.out.println("You have 2 options farm or to attack enemy");
        System.out.println();
        System.out.println("LET'S GO FIGHTT!!");
        printField(field);

        System.out.println("You need to farm now when you feel ready to attack type Attack ");
        System.out.println("Or else just type Farm to keep farming");
        answer = scanner.nextLine();
        while (true) {
            if (answer.equals("Farm")) {
                bottom.ad += 100;
                System.out.println("Your power now is " + bottom.ad);
                System.out.println("Do you want to attack");
            } else if (answer.equals("Attack")) {
                if (bottom.ad > 300) {
                    System.out.println("You killed enemy");
                    field.getMatrix()[2][6] = '-';
                    field.getMatrix()[1][6] = 'B';
                    printField(field);
                    return;
                } else {
                    System.out.println("You died!");

                    return;
                }
            }

            answer = scanner.nextLine();
        }



    }
    public static void printField(Field field) {
        for (int row = 0; row < field.getMatrix().length; row++) {
            for (int col = 0; col < field.getMatrix()[row].length; col++) {
                System.out.print(field.getMatrix()[row][col]);
            }
            System.out.println();
        }
    }
}
