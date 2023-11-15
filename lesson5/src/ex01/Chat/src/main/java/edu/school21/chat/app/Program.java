package edu.school21.chat.app;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.HikariDS;
import edu.school21.chat.repositories.MessageRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(HikariDS.getDataSource());
        Message message = messageRepository.findById(8).orElse(null);
        System.out.println(message);
    }
}
