package src.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import src.exception.InvalidUserDataException;
import src.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {

    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepositoryFileImpl();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Создание нового пользователя")
    void testCreateNewUser() {

        User user = new User(UUID.fromString(
                "f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d2"),
                LocalDateTime.now(),
                "petya007",
                "007Qwerty",
                "007Qwerty",
                "Петров",
                "Петр",
                "Петрович",
                99,
                true);
        assertDoesNotThrow(() -> usersRepository.create(user));
    }

    @Test
    @DisplayName("Нахождение пользователя по id")
    void testFindById() {
        UsersRepositoryFileImpl usersRepositoryFile = new UsersRepositoryFileImpl();
        User user = usersRepositoryFile.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d1");
        assertAll(
                () -> assertEquals(user.getName(), "Евгений"),
                () -> assertEquals(user.getSurname(), "Носов")
        );

    }


    @Test
    @DisplayName("Удаление пользователя по id")
    void testDeleteById() {
        User user = new User(UUID.fromString(
                "f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d0"),
                LocalDateTime.now(),
                "noisemc_98",
                "789ghu",
                "789ghu",
                "Табуреткин",
                "Илья",
                "Богданович",
                21,
                true);
        assertDoesNotThrow(() -> {
            usersRepository.create(user);
            usersRepository.deleteById(user.getId());
            // assertNull(usersRepository.findById("f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d0"));

        });

    }


    @Test
    @DisplayName("Тест на валидацию пользователя")
    void testValidateUser()  {
        User user = new User(UUID.fromString(
                "f5a8a3cb-4ac9-4b3b-8a65-c424e129b9d0"),
                LocalDateTime.now(),
                null,
                null,
                "789ghu",
                "Табуреткин",
                "Илья",
                "Богданович",
                -90,
                true);
        assertThrows(InvalidUserDataException.class, () -> {
            usersRepository.validateUser(user);
        });

    }
}

