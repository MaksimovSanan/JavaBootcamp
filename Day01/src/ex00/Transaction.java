package ex00;

import java.util.UUID;

public class Transaction {
    private final UUID identifier;
    private final User recipient;
    private final User sender;
    private final transfer transferCategory;
    private final int transferAmount;

    public enum transfer {
        DEBIT, CREDIT
    }

    public Transaction(UUID identifier, User recipient, User sender, transfer transferCategory, int transferAmount) throws Exception{
        if(transferCategory == transfer.DEBIT && transferAmount < 0) throw new RuntimeException("Negative debit");
        if(transferCategory == transfer.CREDIT && transferAmount > 0) throw new RuntimeException("Positive credit");

        this.identifier = identifier;
        this.recipient = recipient;
        this.sender = sender;
        this.transferCategory = transferCategory;
        this.transferAmount = transferAmount;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public transfer getTransferCategory() {
        return transferCategory;
    }

    public int getTransferAmount() {
        return transferAmount;
    }
}
