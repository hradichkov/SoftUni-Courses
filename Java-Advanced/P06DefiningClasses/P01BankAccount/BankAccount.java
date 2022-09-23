package P06DefiningClasses.P01BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int nextId = 1;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = nextId;
        nextId++;
        //this.balance = 0;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
