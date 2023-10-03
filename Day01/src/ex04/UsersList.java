package ex04;

public interface UsersList {
    int getSize();
    void push(User user);
    User getUserById(int id);
    User getUserByIndex(int index);
}
