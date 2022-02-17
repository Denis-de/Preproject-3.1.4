package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    void saveOrUpdate(User user);
    List<User> getUsersList();
    Optional<User> findById(Long id);
    void deleteUser(Long id);
    User findByUserName(String email);
}