package model;
import exception.InsufficientBalanceException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccount {
    private int accountNo;
    private String holderName;
    private double balance;
     public BankAccount(int accountNo,String holderName,double balance){
        this.accountNo=accountNo;
        this.holderName =holderName;
        this.balance =balance;
    }
    private ArrayList<Transaction> transactions = new ArrayList<>();
    public synchronized void deposit(int amount){
        if(amount >0) {
            balance += amount;

            Transaction t = new Transaction(
                    "Deposit",
                    amount,
                    balance,
                    LocalDateTime.now(),
                    Thread.currentThread().getName()
            );

            transactions.add(t);
        }
        else {
            System.out.println("Invalid Amount");
        }
    }
    public synchronized void withdraw(int amount) throws InterruptedException, InsufficientBalanceException {
          if(amount<=0) {
              System.out.println("Invalid Amount");
          }
        else if ( amount <= balance) {

            Thread.sleep(100);
            balance -= amount;

            Transaction t = new Transaction(
                    "Withdraw",
                    amount,
                    balance,
                    LocalDateTime.now(),
                    Thread.currentThread().getName()
            );
            transactions.add(t);

        }
        else {
              throw new InsufficientBalanceException("Balance is too low");
          }

    }
    public void showBalance(){
        System.out.println("Current Balance : ₹" + balance);
    }
    public void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        System.out.println("========== TRANSACTION HISTORY ==========");
        for (Transaction t : transactions){
            System.out.println(t);
            System.out.println("----------------------------------------");
        }
    }


}
