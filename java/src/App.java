package src;

import src.model.User;
import src.repositories.UsersRepositoryFileImpl;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class App {
    public static void main(String[] args) throws RuntimeException, IOException {

        UsersRepositoryFileImpl repository = new UsersRepositoryFileImpl();
        User user = repository.findById("f1a8a3cb-4ac9-4b3b-8a65-c424e129b9d2");
        System.out.println(user);

    }
}