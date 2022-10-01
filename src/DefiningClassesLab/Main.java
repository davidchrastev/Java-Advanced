package DefiningClassesLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            String command = data[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");

            } else if (command.equals("Deposit")) {

                int id = Integer.parseInt(data[1]);

                if (existsOrNot(bankAccounts,id)) {
                    double amount = Double.parseDouble(data[2]);
                    deposit(bankAccounts, amount, id);
                    System.out.printf("Deposited %.0f to ID%d%n",amount,id);
                } else {
                    System.out.println("Account does not exist");
                }

            } else if (command.equals("SetInterest")) {
                double interestRate = Double.parseDouble(data[1]);
                BankAccount.setInterestRate(interestRate);

            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(data[1]);

                if (existsOrNot(bankAccounts,id)) {
                    int years = Integer.parseInt(data[2]);
                    System.out.printf("%.2f%n",getInterest(bankAccounts, id, years));
                } else {
                    System.out.println("Account does not exist");
                }
            }

            input = scanner.nextLine();
        }

    }
    public static double getInterest(Map<Integer, BankAccount> bankAccounts, int id, int years) {
        return bankAccounts.get(id).getInterest(years);
    }

    private static void deposit(Map<Integer, BankAccount> bankAccounts, double amount, int id) {
         bankAccounts.get(id).deposit(amount);
    }

    private static boolean existsOrNot(Map<Integer,BankAccount> bankAccounts,int id) {
        if (bankAccounts.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

}
