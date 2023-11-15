package edu.school21.chat;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private final int id;
    private final String name;
    private final User owner;
    List<Message> messages;

    public Chatroom(int id, String name, User owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return id == chatroom.id && Objects.equals(name, chatroom.name) && Objects.equals(owner, chatroom.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner);
    }
}
