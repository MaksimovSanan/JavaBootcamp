package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
    private int id;
    private final User author;
    private final Chatroom room;
    private final String text;
    private final LocalDateTime date;

    public Message(int id, User author, Chatroom room, String text, LocalDateTime date) {
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    public Message(User author, Chatroom room, String text, LocalDateTime date) {
        this.author = author;
        this.room = room;
        this.text = text;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message : {\n" +
                "id=" + id +
                ",\nauthor=" + author +
                ",\nroom=" + room +
                ",\ntext='" + text + '\'' +
                ",\ndate=" + date +
                "\n}";
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && Objects.equals(author, message.author) && Objects.equals(room, message.room) && Objects.equals(text, message.text) && Objects.equals(date, message.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, room, text, date);
    }
}
