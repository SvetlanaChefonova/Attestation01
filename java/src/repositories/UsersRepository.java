package src.repositories;

import src.model.User;

import java.util.List;
import java.util.UUID;

public interface UsersRepository {
    void create(User user);
    User findById(String id);
    List<User> findAll();
    void update(User user);
    void deleteById(UUID id);
    void deleteAll();
}
