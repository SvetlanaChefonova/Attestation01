package src.model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.UUID;

public class User implements Serializable, Externalizable {
    private UUID id;
    LocalDateTime localDateTime = LocalDateTime.now();
    private String login;
    private String password;
    private String confirmPassword;
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    private Boolean isWorker = false;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    public User() {

    }

    public User(UUID id,
                LocalDateTime localDateTime,
                String login,
                String password,
                String confirmPassword,
                String surname,
                String name,
                String patronymic,
                Integer age,
                Boolean isWorker) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.age = age;
        this.isWorker = isWorker;
    }

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add(""+id)
                .add(""+localDateTime)
                .add(""+login)
                .add(""+password)
                .add(""+confirmPassword)
                .add(""+surname)
                .add(""+name)
                .add(""+patronymic)
                .add(""+age)
                .add(""+isWorker)
                .toString();

    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        ArrayList<String> userString = new ArrayList<>();
        userString.add(0, id.toString());
        userString.add(1, localDateTime.toString());
        userString.add(2, login);
        userString.add(3, password);
        userString.add(4, confirmPassword);
        userString.add(4, surname);
        userString.add(4, name);
        userString.add(4, patronymic);
        userString.add(4, age.toString());
        userString.add(4, isWorker.toString());
        out.writeObject(String.join("\\|", userString));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        var user = in.readObject();
        System.out.println(user);

    }
}
