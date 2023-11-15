package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessageRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class Program
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl();
//        Message message = messageRepository.findById(1).orElse(null);
//        System.out.println(message);
        User abobaUser = new User(701,"ABOBA","000", null, null);
        Chatroom abobaRoom = new Chatroom(1,"ABOBAROOM", abobaUser, null);
        Message message = new Message(null, abobaUser, abobaRoom, "SUPERHELLO", LocalDateTime.now());
        try {
            messageRepository.save(message);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(message.getId());
    }
}
