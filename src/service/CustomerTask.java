package service;

import exception.InsufficientBalanceException;
import model.BankAccount;

public class CustomerTask implements Runnable {
    private BankAccount account;
    private int amount;
    private String operation;
     public CustomerTask(BankAccount account, int amount, String operation) {
        this.account = account;
        this.amount = amount;
        this.operation = operation;
    }

    public void run(){
        if ("withdraw".equals(operation)) {
            try {
                account.withdraw(amount);
            } catch (InterruptedException | InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        } else if ("deposit".equals(operation)) {
            account.deposit(amount);
        }
    }
}
