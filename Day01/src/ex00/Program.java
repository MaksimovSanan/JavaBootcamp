package ex00;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws Exception{

        User user1 = new User(1, "ABOBA", 0);
        User user2 = new User(2, "BOBA", 100);

        System.out.println("user1 - ABOBA");
        System.out.println("user1.getIdentifier() = " + user1.getIdentifier());
        System.out.println("user1.getName() = " + user1.getName());
        System.out.println("user1.getBalance() = " + user1.getBalance());
        System.out.println();

        System.out.println("user2 - BOBA");
        System.out.println("user2.getIdentifier() = " + user2.getIdentifier());
        System.out.println("user2.getName() = " + user2.getName());
        System.out.println("user2.getBalance() = " + user2.getBalance());
        System.out.println();

        System.out.println("user1.setBalance(300)");
        user1.setBalance(300);
        System.out.println("user1.getBalance() = " + user1.getBalance());
        System.out.println();


        System.out.println("new User(2, \"ABOBA_EXCEPTION\", -100)");
        try {
            User userException = new User(2, "ABOBA_EXCEPTION", -100);
        }
        catch (RuntimeException ex) {
            System.out.println(ex);
        }
        System.out.println();


        UUID transactionUUID = UUID.randomUUID();
        System.out.println("new Transaction(transactionUUID, user2, user1, Transaction.transfer.DEBIT, 150)");
        Transaction transactionDebit = new Transaction(transactionUUID, user2, user1, Transaction.transfer.DEBIT, 150);
        System.out.println("transactionDebit.getIdentifier() = " + transactionDebit.getIdentifier());
        System.out.println("transactionDebit.getRecipient().getIdentifier() = " + transactionDebit.getRecipient().getIdentifier());
        System.out.println("transactionDebit.getSender().getIdentifier() = " + transactionDebit.getSender().getIdentifier());
        System.out.println("transactionDebit.getTransferCategory() = " + transactionDebit.getTransferCategory());
        System.out.println("transactionDebit.getTransferAmount() = " + transactionDebit.getTransferAmount());
        System.out.println();

        System.out.println("new Transaction(transactionUUID, user1, user2, Transaction.transfer.CREDIT, -150)");
        Transaction transactionCredit = new Transaction(transactionUUID, user1, user2, Transaction.transfer.CREDIT, -150);
        System.out.println("transactionCredit.getIdentifier() = " + transactionCredit.getIdentifier());
        System.out.println("transactionCredit.getRecipient().getIdentifier() = " + transactionCredit.getRecipient().getIdentifier());
        System.out.println("transactionCredit.getSender().getIdentifier() = " + transactionCredit.getSender().getIdentifier());
        System.out.println("transactionCredit.getTransferCategory() = " + transactionCredit.getTransferCategory());
        System.out.println("transactionCredit.getTransferAmount() = " + transactionCredit.getTransferAmount());
        System.out.println();


        System.out.println("new Transaction(transactionUUID, user1, user2, Transaction.transfer.DEBIT, -150)");
        try {
            Transaction transactionDebitException = new Transaction(transactionUUID, user1, user2, Transaction.transfer.DEBIT, -150);
        }
        catch (RuntimeException ex){
            System.out.println(ex);
        }
        System.out.println();


        System.out.println("new Transaction(transactionUUID, user1, user2, Transaction.transfer.CREDIT, 150)");
        try {
            Transaction transactionDebitException = new Transaction(transactionUUID, user1, user2, Transaction.transfer.CREDIT, 150);
        }
        catch (RuntimeException ex){
            System.out.println(ex);
        }
        System.out.println();
    }

}
