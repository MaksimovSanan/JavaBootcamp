package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(int id);
    void delete(Message message);
    void save(Message message);
    void update(Message message);

    List<Message> findAll();

}
