package P03BankAccount;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static int bankAccountIndexer = 1;
    private int id;
    private double balance;
    private static double interestRare = DEFAULT_INTEREST_RATE;

    public BankAccount() {
        this.id = bankAccountIndexer++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRare(double interestRare) {
        BankAccount.interestRare = interestRare;
    }

    public double getInterest(int years) {
        return balance * interestRare * years;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
}
