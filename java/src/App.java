package src;

import src.model.User;
import src.repositories.UsersRepositoryFileImpl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) throws RuntimeException, IOException {


        //проверка метода findById
        UsersRepositoryFileImpl repository = new UsersRepositoryFileImpl();
        User user = repository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        System.out.println(user);

        //проверка метода findAll
        UsersRepositoryFileImpl repository1 = new UsersRepositoryFileImpl();
        List<User> allUsers = repository1.findAll();
        System.out.println("Все пользователи: \n"+ allUsers);

        //проверка метода deleteById
        UsersRepositoryFileImpl repository2 = new UsersRepositoryFileImpl();
        repository2.deleteById(UUID.fromString("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"));
        System.out.println(repository2);
        return ;

    }
}