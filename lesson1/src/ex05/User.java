package ex05;


public class User {
    private final int identifier;
    private final String name;
    private double balance;

//    private TransactionsList transactions = new TransactionsLinkedList();
    public final TransactionsList transactions;

    public User(String name, double balance, TransactionsList implementation) throws Exception{
        if(balance < 0) throw new RuntimeException("Negative balance");
        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
        this.transactions = implementation;
    }

    public int getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return name + " - " + balance;
    }
}
