package ex03;

import java.util.Arrays;
import java.util.UUID;

public class Program {
    public static void main(String[] args) throws Exception{

        User user1 = new User("ABOBA", 0, new TransactionsLinkedList());
        User user2 = new User("BOBA", 100, new TransactionsLinkedList());
        User user3 = new User("BOBA3", 100, new TransactionsLinkedList());
        User user4 = new User("BOBA4", 100, new TransactionsLinkedList());
        User user5 = new User("BOBA5", 100, new TransactionsLinkedList());
        User user6 = new User("BOBA6", 100, new TransactionsLinkedList());
        User user7 = new User("BOBA7", 100, new TransactionsLinkedList());
        User user8 = new User("BOBA8", 100, new TransactionsLinkedList());
        User user9 = new User("BOBA9", 100, new TransactionsLinkedList());
        User user10 = new User("BOBA10", 100, new TransactionsLinkedList());
        User user11 = new User("BOBA11", 100, new TransactionsLinkedList());

        UsersList users = new UsersArrayList();
        users.push(user1);
        users.push(user2);
        users.push(user3);
        users.push(user4);
        users.push(user5);
        users.push(user6);
        users.push(user7);
        users.push(user8);
        users.push(user9);
        users.push(user10);
        users.push(user11);

        UUID transaction1uuid = UUID.randomUUID();

        Transaction t1 = new Transaction(transaction1uuid, user3, user2, Transaction.transfer.DEBIT, 300);
        Transaction t2 = new Transaction(transaction1uuid, user2, user3, Transaction.transfer.CREDIT, -300);
        users.getUserById(1).transactions.addTransaction(t1);
        users.getUserById(2).transactions.addTransaction(t2);

        UUID transaction2uuid = UUID.randomUUID();
        Transaction t3 = new Transaction(transaction2uuid, user5, user2, Transaction.transfer.CREDIT, -1000);
        users.getUserById(1).transactions.addTransaction(t3);

        System.out.println(Arrays.toString(users.getUserById(1).transactions.toArray()));
        System.out.println(Arrays.toString(users.getUserById(4).transactions.toArray()));


        users.getUserById(1).transactions.removeTransaction(transaction2uuid);
        System.out.println(Arrays.toString(users.getUserById(1).transactions.toArray()));

        try{
            users.getUserById(1).transactions.removeTransaction(transaction2uuid);
        }
        catch(TransactionNotFoundException ex) {
            System.out.println(ex);
        }
    }

}
