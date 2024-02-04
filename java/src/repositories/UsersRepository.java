package src.repositories;

import src.model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface UsersRepository {
    void create(User user);
    User findById(String id) throws IOException;
    List<User> findAll();
    void update(User user);
    void deleteById(UUID id) throws IOException;
    void deleteAll() throws IOException;
}
