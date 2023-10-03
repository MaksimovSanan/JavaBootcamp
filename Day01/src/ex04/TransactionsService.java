package ex04;

import java.util.UUID;

public class TransactionsService {
    private final UsersList users;

    public TransactionsService(UsersList implementation) {
        this.users = implementation;
    }

    public void addUser(User user) {
        users.push(user);
    }

    public double getUserBalance(int userId) {
        return users.getUserById(userId).getBalance();
    }

    public void addTransaction(int senderId, int recipientId, double sum) throws Exception {
        UUID transactionId = UUID.randomUUID();

        User recipient = users.getUserById(recipientId);
        User sender = users.getUserById(senderId);

        if(users.getUserById(senderId).getBalance() < sum) {
            throw new IllegalTransactionException("MALO BALANCE");
        }

        sender.setBalance(sender.getBalance() - sum);
        recipient.setBalance(recipient.getBalance() + sum);

        Transaction transactionForRecipient = new Transaction(transactionId, recipient, sender, Transaction.transfer.DEBIT, sum);
        Transaction transactionForSender = new Transaction(transactionId, sender, recipient, Transaction.transfer.CREDIT, -sum);

        sender.transactions.addTransaction(transactionForSender);
        recipient.transactions.addTransaction(transactionForRecipient);
    }

    public Transaction[] getTransactions(int id) {
        return users.getUserById(id).transactions.toArray();
    }

    public void removeTransaction(UUID transactionId, int userId) {
        users.getUserById(userId).transactions.removeTransaction(transactionId);
    }

    public Transaction[] getUnpairedTransaction(){

        TransactionsLinkedList res = new TransactionsLinkedList();

        for(int i = 0; i < users.getSize(); ++i) {
            for(Transaction transaction1 : users.getUserByIndex(i).transactions.toArray()) {
                boolean find = false;
                UUID tmp = transaction1.getIdentifier();
                for(Transaction transaction2 : users.getUserById(transaction1.getSender().getIdentifier()).transactions.toArray()) {
                    if (transaction2.getIdentifier() == tmp) {
                        find = true;
                        break;
                    }
                }
                if(!find) res.addTransaction(transaction1);
            }
        }
        return res.toArray();
    }
}
