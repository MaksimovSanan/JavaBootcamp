package edu.school21.chat.repositories;

import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.util.List;
import java.util.Optional;

public interface MessageRepository {
    Optional<Message> findById(int id);
    void delete(Message message);
    void save(Message message) throws NotSavedSubEntityException;
    void update(Message message);

    List<User> findAll(int page, int size);

}
