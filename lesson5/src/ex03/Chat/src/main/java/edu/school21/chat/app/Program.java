package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessageRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.HikariDS;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class Program
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!03" );

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(HikariDS.getDataSource());
        Optional<Message> messageOptional = messageRepository.findById(12);
        if(messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDate(null);
            messageRepository.update(message);
        }
        else {
            System.out.println("MESSAGE NOT FOUND");
        }
    }
}
