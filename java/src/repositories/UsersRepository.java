package src.repositories;

import src.model.User;

import java.io.IOException;
import java.util.List;

public interface UsersRepository {
    void create(User user);
    User findById(String id) throws IOException;
    List<User> findAll();
    void update(User user);
    void deleteById(String id);
    void deleteAll();
}
