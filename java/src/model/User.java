package src.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {
    private String id;
    LocalDateTime localDateTime = LocalDateTime.now();
    private String login;
    private String password;
    private String confirmPassword;
    private String surname;
    private String name;
    private String patronymic;
    private Integer age;
    private Boolean isWorker = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public User(String id, LocalDateTime localDateTime, String login, String password, String confirmPassword, String surname, String name, String patronymic, Integer age, Boolean isWorker) {
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
        return "User{" +
                "id='" + id + '\'' +
                ", localDateTime=" + localDateTime +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", isWorker=" + isWorker +
                '}';
    }


}
