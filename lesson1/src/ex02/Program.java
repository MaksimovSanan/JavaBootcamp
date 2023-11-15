package ex02;

public class Program {
    public static void main(String[] args) throws Exception{

        User user1 = new User("ABOBA", 0);
        User user2 = new User("BOBA", 100);
        User user3 = new User("BOBA3", 100);
        User user4 = new User("BOBA4", 100);
        User user5 = new User("BOBA5", 100);
        User user6 = new User("BOBA6", 100);
        User user7 = new User("BOBA7", 100);
        User user8 = new User("BOBA8", 100);
        User user9 = new User("BOBA9", 100);
        User user10 = new User("BOBA10", 100);
        User user11 = new User("BOBA11", 100);

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

        System.out.println("users.getSize() = " + users.getSize());
        System.out.println("users.getUserById(0).getName() - " + users.getUserById(0).getName());
        System.out.println("users.getUserById(10).getName() - " + users.getUserById(10).getName());


        try {
            String name = users.getUserById(11).getName();
        }
        catch (UserNotFoundException ex) {
            System.out.println("users.getUserById(11).getName() - " + ex);
        }

    }

}
