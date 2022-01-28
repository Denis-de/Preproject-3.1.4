package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;
import java.util.List;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(Long id);
    User getUserById(Long id);
    List<User> listUsers();
    User getUserByEmail(String email);
}