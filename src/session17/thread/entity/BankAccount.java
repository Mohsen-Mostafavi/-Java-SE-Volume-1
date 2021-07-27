package session17.thread.entity;

public class BankAccount {
    
    private int number;
    private String owner;
    private long balance;

    public BankAccount() {
    }

    public BankAccount(int number, String owner, long balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    
    void deposit(long amount) {
        balance += amount;
    }
    
    void withdraw(long amount) {
        balance -= amount;
    }
    
}
