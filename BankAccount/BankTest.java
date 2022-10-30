public class BankTest{
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        account1.depositMoney("savings", 2000);
        account1.withdrawMoney("savings", 100);
        account1.withdrawMoney("savings", 500);
        account1.depositMoney("checking", 500);
        account1.checkMyBalance();
    }
}