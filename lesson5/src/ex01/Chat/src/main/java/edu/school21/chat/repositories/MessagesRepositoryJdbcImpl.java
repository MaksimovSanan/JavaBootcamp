package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository{

    private final DataSource dataSource;
    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(int id) {
        try(Connection con = dataSource.getConnection()) {
            PreparedStatement stmt = con.prepareStatement
                    ("SELECT " +
                            "m.id, m.text, m.date, u.id AS user_id, u.login AS user_login, u.password AS user_password, room.id AS room_id, room.name AS room_name " +
                            "FROM messages AS m " +
                            "JOIN users AS u ON m.author_id = u.id " +
                            "JOIN chatrooms AS room ON m.room_id = room.id " +
                            "WHERE m.id = ?");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if(!resultSet.next()) return Optional.empty();
            Message message = new Message(
                    resultSet.getInt("id"),
                    new User(
                            resultSet.getInt("user_id"),
                            resultSet.getString("user_login"),
                            resultSet.getString("user_password"),
                            null,
                            null
                            ),
                    new Chatroom(resultSet.getInt("room_id"),
                            resultSet.getString("room_name"),
                            null,
                            null
                    ),
                    resultSet.getString("text"),
                    resultSet.getTimestamp("date").toLocalDateTime()
                    );
            return Optional.of(message);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }

    @Override
    public void delete(Message message) {
        try(Connection con = dataSource.getConnection()){
            PreparedStatement stmt = con.prepareStatement
                    ("DELETE FROM messages WHERE id = ?");
            stmt.setInt(1, message.getId());
            stmt.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void save(Message message) {
        try(Connection con = dataSource.getConnection()){
            PreparedStatement stmt =  con.prepareStatement
                    ("INSERT INTO messages (author_id, room_id, text, date) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, message.getAuthor().getId());
            stmt.setInt(2, message.getRoom().getId());
            stmt.setString(3, message.getText());
            stmt.setTimestamp(4, Timestamp.valueOf(message.getDate()));
            stmt.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Message message) {
        try(Connection con = dataSource.getConnection()){
            PreparedStatement stmt =  con.prepareStatement
                    ("UPDATE messages SET author_id = ?, room_id = ?, text = ?, date = ? WHERE id = ?");

            stmt.setInt(1, message.getAuthor().getId());
            stmt.setInt(2, message.getRoom().getId());
            stmt.setString(3, message.getText());
            stmt.setTimestamp(4, Timestamp.valueOf(message.getDate()));
            stmt.setInt(5, message.getId());
            stmt.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Message> findAll() {
//        List<Message> result = new LinkedList<>();
//        try(Connection con = DataSource.getConnection()) {
//            PreparedStatement stmt = con.prepareStatement
//                    ("SELECT * FROM messages ");
//            ResultSet resultSet = stmt.executeQuery();
//            while(resultSet.next()) {
//                Message message = new Message(resultSet.getInt("id"), )
//            }
//        }
//        catch(Exception e) {
//            System.out.println(e);
//        }
        return null;
    }


}

