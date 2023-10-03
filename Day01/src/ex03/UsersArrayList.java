package ex03;

public class UsersArrayList implements UsersList {
    private int capacity = 10;
    private int size = 0;
    private User[] users = new User[capacity];

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void push(User user) {
        if(!(capacity > size)) {
            capacity *= 2;
            User[] new_users = new User[capacity];
            for(int i = 0; i < size; ++i) {
                new_users[i] = users[i];
            }
            users = new_users;
        }
        users[size++] = user;
    }

    @Override
    public User getUserById(int id) {
        for(int  i = 0; i < size; ++i) {
            if(users[i].getIdentifier() == id) return users[i];
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public User getUserByIndex(int index) {
        if(users[index] == null) throw new UserNotFoundException("User not found");
        return users[index];
    }
}
