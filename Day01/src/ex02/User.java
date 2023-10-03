package ex02;

public class User {
    private final int identifier;
    private final String name;
    private double balance;

    public User(String name, double balance) throws Exception{
        if(balance < 0) throw new RuntimeException("Negative balance");
        this.identifier = UserIdsGenerator.getInstance().generateId();
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
