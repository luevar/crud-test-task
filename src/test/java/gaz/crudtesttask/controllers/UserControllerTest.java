package gaz.crudtesttask.controllers;

import gaz.crudtesttask.exceptions.FieldNotPresentException;
import gaz.crudtesttask.models.User;
import gaz.crudtesttask.services.UserServiceInterface;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

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
    void fieldNotPresentTest() {
        User user = new User(null, null);
        assertThrows(FieldNotPresentException.class, () -> userController.createUser(user));
    }
}