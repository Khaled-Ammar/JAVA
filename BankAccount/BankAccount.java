class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static double totalMoney = 0.0;
    private static double accountNumber;

    public BankAccount() {
        numberOfAccounts++;
        System.out.println(numberOfAccounts);
    }

    public BankAccount(double checkingBalance, double savingsBalance) {
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        numberOfAccounts++;
        System.out.println(numberOfAccounts);
    }

    public void depositMoney(String type, double money) {
        if (type == "checking") {
            double moneyAdded1 = getCheckingBalance() + money;
            setCheckingBalance(moneyAdded1);
            totalMoney += money;
            // System.out.println("Money deposited: $" + totalMoney);
        }
        if (type == "savings") {
            double moneyAdded2 = getSavingsBalance() + money;
            setCheckingBalance(moneyAdded2);
            totalMoney += money;
            System.out.println("Money deposited: $" + totalMoney);
        }
    }

    public void withdrawMoney(String type, double wdMoney) {
        if (type == "checking") {
            if (totalMoney >= wdMoney) {
                double moneyWithdrawn1 = getCheckingBalance() - wdMoney;
                setCheckingBalance(moneyWithdrawn1);
                totalMoney -= wdMoney;
                System.out.println("Your remaining money: $" + totalMoney);
            } else {
                System.out.println("insufficient funds");
            }
        }
        if (type == "savings") {
            if (totalMoney >= wdMoney) {

                double moneyWihdrawn2 = getSavingsBalance() - wdMoney;
                setCheckingBalance(moneyWihdrawn2);
                totalMoney -= wdMoney;
                System.out.println("Your remaining money: $" + totalMoney);
            } else {
                System.out.println("insufficient funds");
            }
        }
    }

    public void checkMyBalance() {
        System.out.println("Your total money is: $" + totalMoney);
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }
}