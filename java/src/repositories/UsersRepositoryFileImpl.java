package src.repositories;

import src.exception.InvalidUserDataException;
import src.model.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository {

    @Override
    public void validateUser(User user) throws InvalidUserDataException{
        if(user.getId() == null) {
            throw new InvalidUserDataException("ID не может быть пустой строкой");
        }
        if (user.getAge() <=0 && user.getAge() >= 80 ) {
            throw new InvalidUserDataException("Возраст не должен превышать 80 лет и не может быть отрицательным числом");
        }
        if (user.getLogin() == null) {
            throw new InvalidUserDataException("Логин не может быть пустой строкой");
        }
        if (user.getPassword() == null) {
            throw new InvalidUserDataException("Пароль не может быть пустой строкой");
        }
    }


    public void create(User user) throws InvalidUserDataException {
        validateUser(user);

        try (var writer = new PrintStream(new FileOutputStream("users.txt", true), true, StandardCharsets.UTF_8)) {
        writer.write((user.toString() + "\n").getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(String id) throws RuntimeException {
        try {
            var reader = new BufferedReader(new FileReader("users.txt", StandardCharsets.UTF_8));
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
        try (var reader = new BufferedReader(new FileReader("users.txt", StandardCharsets.UTF_8))) {
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
        AtomicBoolean newUser = new AtomicBoolean(true);
        var newUserList = getUsersInternal().stream()
                .map(fileUser -> {
                    if (fileUser.getId().equals(userToUpdate.getId())) {
                        fileUser.setName(userToUpdate.getName());
                        fileUser.setLocalDateTime(userToUpdate.getLocalDateTime());
                        fileUser.setLogin(userToUpdate.getLogin());
                        fileUser.setPassword(userToUpdate.getPassword());
                        fileUser.setConfirmPassword(userToUpdate.getConfirmPassword());
                        fileUser.setSurname(userToUpdate.getSurname());
                        fileUser.setPatronymic(userToUpdate.getPatronymic());
                        fileUser.setAge(userToUpdate.getAge());
                        fileUser.setWorker(userToUpdate.isWorker());
                        return userToUpdate;
                    } else {
                        newUser.set(true);

                    } return fileUser;
                });
        try (var writer = new PrintStream(new FileOutputStream("users.txt", false), true, StandardCharsets.UTF_8)) {

                newUserList.forEach(user -> {
                    try {
                        writer.write((user.toString() + "\n").getBytes());

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            if (newUser.get()) {
                writer.write((userToUpdate + "\n").getBytes());
            } else {
                return;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(UUID id) {
        var users = getUsersInternal();
        var newUserList = users.stream()
                .filter(user -> !user.getId().equals(id))
                .toList();
        try (var writer = new PrintStream(new FileOutputStream("users.txt", false), true, StandardCharsets.UTF_8)) {
            newUserList.forEach(user -> {
                try {
                    writer.write((user.toString() + "\n").getBytes());
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
        FileWriter writer1 = new FileWriter("users.txt", StandardCharsets.UTF_8);
        writer1.write(users.toString());

    }


}
