package edu.school21.chat.app;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessageRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.chat.repositories.HikariDS;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class Program
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!04" );

        MessageRepository messageRepository = new MessagesRepositoryJdbcImpl(HikariDS.getDataSource());
        List<User> listUsers = messageRepository.findAll(1, 3);
        for(User user: listUsers) {
            System.out.println("User: " + user.getLogin());
            System.out.println("Created rooms: ");
            for(Chatroom chatroom: user.getCreatedRooms()) {
                System.out.println(chatroom.getName());
            }
            System.out.println("Participate rooms: ");
            for(Chatroom chatroom: user.getRooms()) {
                System.out.println(chatroom.getName());
            }
            System.out.println();
        }

    }
}
