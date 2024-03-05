package src.repositories;

import src.exception.InvalidUserDataException;
import src.model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface UsersRepository {
    void validateUser(User user) throws InvalidUserDataException;

    void create(User user) throws InvalidUserDataException;
    User findById(String id) throws IOException;
    List<User> findAll();
    void update(User user);
    void deleteById(UUID id);
    void deleteAll() throws IOException;


}
