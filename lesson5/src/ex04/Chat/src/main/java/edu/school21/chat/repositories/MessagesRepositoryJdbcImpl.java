package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
                            "m.id, m.text, m.date, u.id AS user_id, u.login AS user_login, " +
                            "u.password AS user_password, room.id AS room_id, room.name AS room_name " +
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
                    resultSet.getTimestamp("date") != null ?
                            resultSet.getTimestamp("date").toLocalDateTime() : null
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
    public void save(Message message) throws NotSavedSubEntityException{

        if(message.getAuthor().getId() == null || message.getRoom().getId() == null){
            throw  new NotSavedSubEntityException("ID CANNOT BE NULL");
        }

        try {
            Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM users WHERE id = " + message.getAuthor().getId());
            if(!resultSet.next()) throw new NotSavedSubEntityException("USER NOT FOUND");
            resultSet = stmt.executeQuery("SELECT * FROM chatrooms WHERE id = " + message.getRoom().getId());
            if(!resultSet.next()) throw new NotSavedSubEntityException("CHATROOM NOT FOUND");
        } catch (NotSavedSubEntityException e) {
            throw e;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try(Connection con = dataSource.getConnection()){
            PreparedStatement stmt =  con.prepareStatement
                    ("INSERT INTO messages (author_id, room_id, text, date) VALUES (?, ?, ?, ?)", new String[] {"id"});
            stmt.setInt(1, message.getAuthor().getId());
            stmt.setInt(2, message.getRoom().getId());
            stmt.setString(3, message.getText());
            stmt.setTimestamp(4, Timestamp.valueOf(message.getDate()));
            stmt.executeUpdate();
            ResultSet gk = stmt.getGeneratedKeys();
            if(gk.next()) {
                message.setId(gk.getInt("id"));
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
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
            stmt.setTimestamp(4, message.getDate() != null? Timestamp.valueOf(message.getDate()) : null);
            stmt.setInt(5, message.getId());
            stmt.executeUpdate();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<User> findAll(int page, int size) {
        List<User> resultListUsers = new ArrayList<>();
        try {
            Connection con = dataSource.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "with cte_users as (select * from users order by id LIMIT ? OFFSET ?) " +
                    "SELECT cte_users.id, cte_users.login, cte_users.password, " +
                    "created_room.id AS created_room_id, created_room.name AS created_room_name, " +
                    "participate_room.id AS participate_room_id, participate_room.name AS participate_room_name, " +
                    "user_creator.id AS owner_of_participate_room_id, " +
                    "user_creator.login AS owner_of_participate_room_login, " +
                    "user_creator.password AS owner_of_participate_room_password from cte_users " +
                    "LEFT JOIN chatrooms AS created_room ON created_room.owner_id = cte_users.id " +
                    "LEFT JOIN messages AS m ON m.author_id = cte_users.id " +
                    "LEFT JOIN chatrooms AS participate_room ON participate_room.id = m.room_id " +
                    "LEFT JOIN users AS user_creator ON user_creator.id = participate_room.owner_id"
            );
            stmt.setInt(1, size);
            stmt.setInt(2, page  * size);
            ResultSet resultSet= stmt.executeQuery();
            while(resultSet.next()) {
                User user;
                int userId = resultSet.getInt(1);
                if((user = findUserInList(userId, resultListUsers)) == null){
                    user = new User(
                            userId,
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            new ArrayList<>(),
                            new ArrayList<>()
                    );
                    resultListUsers.add(user);
                }

                int created_room_id = resultSet.getInt("created_room_id");
                if(!existsRoomInList(created_room_id, user.getCreatedRooms())) {
                    Chatroom chatroom = new Chatroom(
                            created_room_id,
                            resultSet.getString("created_room_name"),
                            user,
                            null
                    );
                    user.getCreatedRooms().add(chatroom);
                }

                int participate_room_id = resultSet.getInt("participate_room_id");
                if(!existsRoomInList(participate_room_id, user.getRooms())) {
                    User owner = new User(
                            resultSet.getInt("owner_of_participate_room_id"),
                            resultSet.getString("owner_of_participate_room_login"),
                            resultSet.getString("owner_of_participate_room_password"),
                            null,
                            null
                    );
                    Chatroom chatroom = new Chatroom(
                            participate_room_id,
                            resultSet.getString("participate_room_name"),
                            owner,
                            null
                    );
                    user.getRooms().add(chatroom);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Collections.reverse(resultListUsers);
        return resultListUsers;
    }

    private User findUserInList(int id, List<User> listUsers) {
        User result = null;
        for(User user: listUsers) {
            if(user.getId() == id) {
                result = user;
            }
        }
        return result;
    }

    private boolean existsRoomInList(int id, List<Chatroom> listChatrooms) {
        for(Chatroom chatroom: listChatrooms) {
            if(chatroom.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}