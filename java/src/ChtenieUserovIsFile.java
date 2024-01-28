package src;

import src.model.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ChtenieUserovIsFile {
    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("users.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            User user1 = (User) ois.readObject();
            User user2 = (User) ois.readObject();

            System.out.println(user1);
            System.out.println(user2);

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
