package src;

import src.model.User;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ChtenieUserovIsFile {
    public static void main(String[] args) {


    }

    public static User user(String[] userInfoArray) {
        User user = new User(UUID.fromString(userInfoArray[0]), LocalDateTime.parse(userInfoArray[1]), userInfoArray[2], userInfoArray[3], userInfoArray[4], userInfoArray[5], userInfoArray[6], userInfoArray[7], Integer.parseInt(userInfoArray[8]), Boolean.parseBoolean(userInfoArray[9]));
        return user;
    }
}
