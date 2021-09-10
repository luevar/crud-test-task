package gaz.crudtesttask.services;

import gaz.crudtesttask.exceptions.InvalidFieldFormatException;
import gaz.crudtesttask.exceptions.UserNotFoundException;
import gaz.crudtesttask.models.User;
import gaz.crudtesttask.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceTest {
    private UserServiceInterface userService;
    private UserRepository userRepository;

    @BeforeAll
    public void init() {
        userRepository = mock(UserRepository.class);
        userService = spy(new UserService(userRepository));
    }

    @Test
    void invalidNameTest() {
        User user = new User("31232", "+79139526213");
        assertThrows(InvalidFieldFormatException.class, () -> userService.createUser(user));
    }

    @Test
    void invalidPhoneNumberTest() {
        User user = new User("Alexander Miller", "2211aa");
        assertThrows(InvalidFieldFormatException.class, () -> userService.createUser(user));
    }

    @Test
    void validFieldsTest() {
        User user = new User("Alexander Miller", "+79139526213");
        doReturn(user).when(userRepository).save(user);
        user.setId(1L);
        assertDoesNotThrow(() -> userService.createUser(user));
    }

    @Test
    void userNotFoundTest() {
        Long id = 1L;
        doReturn(Optional.empty()).when(userRepository).findById(id);
        assertThrows(UserNotFoundException.class, () -> userService.getUser(id));
    }

    @Test
    void userFoundTest() {
        User user = new User("Alexander Miller", "+79139526213");
        user.setId(1L);
        doReturn(Optional.of(user)).when(userRepository).findById(1L);
        assertDoesNotThrow(() -> userService.getUser(1L));
    }
}