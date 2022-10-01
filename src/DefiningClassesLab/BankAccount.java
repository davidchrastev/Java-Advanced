package DefiningClassesLab;

public class BankAccount {

    private static int nextId = 1;
    private static double interestRate = 0.02;
    private int id;
    private double balance;

    public int getId() {
        return id;
    }

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return balance * years * interestRate;
    }
    public void deposit(double amount) {
        balance += amount;
    }
}
