package ex04;

import java.util.Arrays;
import java.util.UUID;

public class Program {
    public static void main(String[] args) throws Exception{

        TransactionsService test = new TransactionsService(new UsersArrayList());

        User user1 = new User("ABOBA1",300, new TransactionsLinkedList());
        User user2 = new User("ABOBA2",1000, new TransactionsLinkedList());
        User user3 = new User("ABOBA3",1500, new TransactionsLinkedList());

        test.addUser(user1);
        test.addUser(user2);
        test.addUser(user3);

        test.addTransaction(user2.getIdentifier(), user1.getIdentifier(), 200);

        System.out.println("ABOBA2 transactions\n" + Arrays.toString(test.getTransactions(user2.getIdentifier())));
        System.out.println("ABOBA1 transactions\n" + Arrays.toString(test.getTransactions(user1.getIdentifier())));

        System.out.println(test.getUserBalance(user1.getIdentifier()));

    }

}
