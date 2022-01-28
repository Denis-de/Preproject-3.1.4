package web.dao;


import web.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    User getUserById(long id);
    List<User> listUsers();
    User getUserByEmail(String email);
}