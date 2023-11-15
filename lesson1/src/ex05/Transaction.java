package ex05;

import java.util.UUID;

public class Transaction {
    private final UUID identifier;
    private final User recipient;
    private final User sender;
    private final transfer transferCategory;
    private final double transferAmount;

    private Transaction next;
    private Transaction prev;


    public enum transfer {
        DEBIT, CREDIT
    }

    public Transaction(UUID identifier, User recipient, User sender, transfer transferCategory, double transferAmount) throws Exception{
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

    public double getTransferAmount() {
        return transferAmount;
    }

    public Transaction getNext() {
        return next;
    }

    public void setNext(Transaction next) {
        this.next = next;
    }

    public Transaction getPrev() {
        return prev;
    }

    public void setPrev(Transaction prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        if(transferCategory == transfer.CREDIT) {
            return "To " + recipient.getName() + "(id = " + recipient.getIdentifier() + ") " + transferAmount + " with id = " + identifier;
        }
        else {
            return "From " + recipient.getName() + "(id = " + recipient.getIdentifier() + ") " + transferAmount + " with id = " + identifier;
        }
    }
}
