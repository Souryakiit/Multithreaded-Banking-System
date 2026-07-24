package model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Transaction {
    private String type;
    private double amount;
    private double remainingBalance;
    private LocalDateTime time;
    private String threadName;



    public String getType() {
        return type;
    }

    public String getThreadName() {
        return threadName;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public double getAmount() {
        return amount;
    }

     public Transaction(String type, double amount, double remainingBalance, LocalDateTime time, String threadName){
        this.type=type;
        this.amount=amount;
        this.remainingBalance=remainingBalance;
        this.time=time;
        this.threadName=threadName;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss a");

        return "----------------------------" +
                "\nType : " + type +
                "\nAmount : ₹" + amount +
                "\nRemaining Balance : ₹" + remainingBalance +
                "\nThread : " + threadName +
                "\nTime : " + time.format(formatter) +
                "\n----------------------------";
    }
}
