import model.BankAccount;
import service.CustomerTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount(101, "Sourya", 10000);
        CustomerTask t1 = new CustomerTask(account, 2000, "withdraw");
        CustomerTask t2 = new CustomerTask(account, 5000, "deposit");
        CustomerTask t3 = new CustomerTask(account, 3000, "withdraw");
        Thread th1 = new Thread(t1);
        Thread th2 = new Thread(t2);
        Thread th3 = new Thread(t3);
        th1.start();
        th2.start();
        th3.start();
        th1.join();
        th2.join();
        th3.join();
        account.showBalance();
        account.showTransactionHistory();
    }
}
