public class BankAccount {
    public String name;
    public String accountNumber;
    public double checkingBalance;
    public double savingsBalance;
    public static double sumOfAllAccounts = 0;
    private static int numberOfAccounts = 0;

    public BankAccount(String name) {
        this.name = name;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = randomAccountNumber();
        numberOfAccounts++;
    }

    public BankAccount(String name, double checkBalParams, double saveBalParams) {
        this.name = name;
        this.checkingBalance = checkBalParams;
        this.savingsBalance = saveBalParams;
        this.accountNumber = randomAccountNumber();
        sumOfAllAccounts = sumOfAllAccounts + checkBalParams + saveBalParams;
        numberOfAccounts++;
    }

    private String randomAccountNumber() {
        return null;
    }

    // RETURNS NUMBER OF INSTANCES OF BANK ACCOUNT CLASS (ACCOUNTS)
    public static int accountCounter() {
        return numberOfAccounts;
    }

    // DEPOSIT INTO CHECKING ACCOUNT
    public void checkingDeposit(double deposit) {
        this.checkingBalance += deposit;
        sumOfAllAccounts += deposit;
    }

    // WITHDRAW FROM CHECKING ACCOUNT
    public void checkingWithdrawal(double withdrawal) {
        if (withdrawal <= this.checkingBalance) {
            this.checkingBalance -= withdrawal;
            sumOfAllAccounts -= withdrawal;
        } else {
            System.out.println("Checking account balance is too low to withdraw that amount.");
        }
    }

    // DEPOSIT INTO SAVINGS ACCOUNT
    public void savingsDeposit(double deposit) {
        this.savingsBalance += deposit;
        sumOfAllAccounts += deposit;
    }

    // WITHDRAW FROM SAVINGS ACCOUNT
    public void savingsWithdrawal(double withdrawal) {
        if (withdrawal <= this.savingsBalance) {
            this.savingsBalance -= withdrawal;
            sumOfAllAccounts -= withdrawal;
        } else {
            System.out.println("Savings account balance is too low to withdraw that amount.");
        }

    }

    // SHOW CURRENT BALANCE (ACCOUNT STATEMENT)
    public void printAccountStatement() {
        System.out.println(
                this.name + "'s Accounts | Checking: $" + checkingBalance + "0 | Savings: $" + savingsBalance + "0");
    }

}
