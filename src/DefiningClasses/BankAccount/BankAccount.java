package DefiningClasses.BankAccount;

class BankAccount {
    private static int accountsCount = 1;
    private static double interestRate = 0.02;
    private double balance;
    private int id;

    public BankAccount() {
        this.id = accountsCount;
        accountsCount++;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * years * balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
