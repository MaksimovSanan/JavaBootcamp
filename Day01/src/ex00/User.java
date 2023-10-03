package ex00;

public class User {
    private final int identifier;
    private final String name;
    private double balance;

    public User(int identifier, String name, double balance) throws Exception{
        if(balance < 0) throw new RuntimeException("Negative balance");
        this.identifier = identifier;
        this.name = name;
        this.balance = balance;
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

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
