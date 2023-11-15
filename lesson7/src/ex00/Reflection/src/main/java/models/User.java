package models;

public class User {
    private String firstName;
    private String lastName;
    private Integer height;

    public User() {
        this.firstName = "Default first name";
        this.lastName = "Default last name";
        this.height = 0;
    }

    public User(String firstName, String lastName, Integer height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }

    public int grow(Integer value) {
        this.height += value;
        return height;
    }

    public int grow() {
        this.height += 10;
        return height;
    }

    public void grow100() {
        this.height += 10;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                '}';
    }
}

