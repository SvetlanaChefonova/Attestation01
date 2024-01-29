package src.repositories;

import src.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UsersRepositoryFileImpl implements UsersRepository{
    public void create(User user){


    }

    public User findById(String id) throws RuntimeException {

        try{
            var reader = new BufferedReader(new FileReader("C:\\Users\\Svetlana_Chefonova\\Documents\\file.txt"));
            String stringUser = reader.readLine();
            String idByUser = stringUser.substring(0, 36);
            while (!idByUser.equals(id)) {
                stringUser = reader.readLine();
                if (stringUser == null){
                    throw new RuntimeException("Пользователя с заданным идентификатором не существует");
                }
                idByUser = stringUser.substring(0, 36);
                //return user;
            }
            return user(stringUser.split("\\|"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<User> findAll(){

        try {
            var reader = new BufferedReader(new FileReader("C:\\Users\\Svetlana_Chefonova\\Documents\\file.txt"));

            return reader.lines()
                    .map(line -> line.split("(\\|)"))
                    .map(userInfoArray -> user(userInfoArray)).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return  new ArrayList<>();
    }

    public static User user(String[] userInfoArray) {
        User user = new User(UUID.fromString(userInfoArray[0]), LocalDateTime.parse(userInfoArray[1]), userInfoArray[2], userInfoArray[3], userInfoArray[4], userInfoArray[5], userInfoArray[6], userInfoArray[7], Integer.parseInt(userInfoArray[8]), Boolean.parseBoolean(userInfoArray[9]));
        return user;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(UUID id) {

            List<User> users = findAll();
            users.removeIf(user -> user.getId().equals(id));


    }

    @Override
    public void deleteAll() {

    }


}
