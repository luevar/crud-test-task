package gaz.crudtesttask.controllers;

import gaz.crudtesttask.exceptions.FieldNotPresentException;
import gaz.crudtesttask.models.User;
import gaz.crudtesttask.services.UserServiceInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest {
    private UserController userController;
    private UserServiceInterface userService;

    @BeforeAll
    public void init() {
        userService = mock(UserServiceInterface.class);
        userController = spy(new UserController(userService));
    }

    @Test
    void nameFieldNotPresentTest() {
        User user = new User(null, "+79139526213");
        assertThrows(FieldNotPresentException.class, () -> userController.createUser(user));
    }

    @Test
    void phoneNumberFieldNotPresentTest() {
        User user = new User("Alexander Miller", null);
        assertThrows(FieldNotPresentException.class, () -> userController.createUser(user));
    }

    @Test
    void everythingIsPresentTest() {
        User user = new User("Alexander Miller", "+79139526213");
        doReturn(1L).when(userService).createUser(user);
        assertDoesNotThrow(() -> userController.createUser(user));
    }
}