package src.repositories;

import src.model.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersRepositoryFileImpl implements UsersRepository {
    public void create(User user) {
        try (var writer = new ObjectOutputStream(new FileOutputStream("users.txt", true))) {
        writer.writeObject(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(String id) throws RuntimeException {
        try {
            var reader = new BufferedReader(new FileReader("users.txt"));
            String stringUser = reader.readLine();
            String idByUser = stringUser.substring(0, 36);
            while (!idByUser.equals(id)) {
                stringUser = reader.readLine();
                if (stringUser == null) {
                    throw new RuntimeException("Пользователя с заданным идентификатором не существует");
                }
                idByUser = stringUser.substring(0, 36);
                //return user;
            }
            return user(stringUser.split("\\|"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static User user(String[] userInfoArray) {
        User user = new User(UUID.fromString(userInfoArray[0]),
                    LocalDateTime.parse(userInfoArray[1]),
                    userInfoArray[2],
                    userInfoArray[3],
                    userInfoArray[4],
                    userInfoArray[5],
                    userInfoArray[6],
                    userInfoArray[7],
                    Integer.parseInt(userInfoArray[8]),
                    Boolean.parseBoolean(userInfoArray[9]));
        return user;
    }

    @Override
    public List<User> findAll() {
        return getUsersInternal();
    }

    private static List<User> getUsersInternal(){
        try (var reader = new BufferedReader(new FileReader("users.txt"))) {
            return reader.lines()
                    .map(line -> line.split("(\\|)"))
                    .map(strings -> user(strings))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(User userToUpdate) {
        var newUserList = getUsersInternal().stream()
                .map(fileUser -> {
                    if (fileUser.getId().equals(userToUpdate.getId())) {
                        return userToUpdate;
                    } else {
                        return fileUser;
                    }
                });
        try (var writer = new ObjectOutputStream(new FileOutputStream("users.txt", false))) {
            newUserList.forEach(user -> {
                try {
                    writer.writeObject(user);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(UUID id) throws IOException {
        var users = getUsersInternal();
        var newUserList = users.stream()
                .filter(user -> !user.getId().equals(id))
                .toList();
        try (var writer = new ObjectOutputStream(new FileOutputStream("users.txt", false))) {
            newUserList.forEach(user -> {
                try {
                    writer.writeObject(user);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() throws IOException {
        List<User> users = findAll();
        users.clear();
        System.out.println(users);
        FileWriter writer1 = new FileWriter("users.txt");
        writer1.write(users.toString());

    }


}
