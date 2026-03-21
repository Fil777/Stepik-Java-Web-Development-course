package Ex02BankAccount;

public class Program {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1111-2222-3333-4444");
        BankAccount account2 = new BankAccount(100, "2222-3333-4444-5555");

        System.err.println(account1.getBalance() + " " + account1.getAccountNumber());
        account1.deposit(200);
        System.err.println(account1.getBalance() + " " + account1.getAccountNumber());
        account1.withdraw(250);
        System.err.println(account1.getBalance() + " " + account1.getAccountNumber() + "\n");

        System.err.println(account2.getBalance() + " " + account2.getAccountNumber());
        account2.deposit(200);
        System.err.println(account2.getBalance() + " " + account2.getAccountNumber());
        account2.withdraw(250);
        System.err.println(account2.getBalance() + " " + account2.getAccountNumber());
    }
}
