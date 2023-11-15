package ex01;

import java.util.UUID;

public class Program {
    public static void main(String[] args) throws Exception{

        User user1 = new User("ABOBA", 0);
        User user2 = new User("BOBA", 100);

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
    }

}
