package src;

import src.model.User;
import src.repositories.UsersRepositoryFileImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) throws RuntimeException, IOException {

        //проверка метода create
        User novUser = new User();
        novUser.setId(UUID.fromString("f7a8a3cb-4ac9-4b3b-8a65-c424e129b9d4"));
        novUser.setLocalDateTime(LocalDateTime.now());
        novUser.setLogin("ttt");
        novUser.setPassword("999jjj");
        novUser.setConfirmPassword("999jjj");
        novUser.setName("Ivan");
        novUser.setSurname("Ivanov");
        novUser.setPatronymic("Ivanovich");
        novUser.setAge(Integer.parseInt(String.valueOf(23)));
        novUser.setWorker(Boolean.parseBoolean(String.valueOf(true)));
        System.out.println("Новый пользователь: "+ novUser);


        //проверка метода findById
        UsersRepositoryFileImpl repository = new UsersRepositoryFileImpl();
        User user = repository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d3");
        System.out.println("Поиск пользователя по id: \n" + user);

        //проверка метода findAll
        List<User> allUsers = repository.findAll();
        System.out.println("Все пользователи: \n"+ allUsers);

        //проверка метода update
        novUser.setSurname("Русланов");
        System.out.println(novUser);
        repository.update(novUser);

        //проверка метода deleteById
        UsersRepositoryFileImpl repository2 = new UsersRepositoryFileImpl();
        repository2.deleteById(user.getId());
        List<User> allUsers1 = repository.findAll();
        System.out.println("Список пользователей после удаления одного пользователя: " );
        System.out.println(allUsers1);


        //проверка метода deleteAll
        System.out.println("Все пользователи после удаления: ");
        repository.deleteAll();




    }
}