package gaz.crudtesttask.controllers;

import gaz.crudtesttask.models.User;
import gaz.crudtesttask.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Simple REST controller for operations with users
 */
@RestController
public class UserController {

    private final UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    /**
     * Saves the new user passed from the client
     *
     * @param user the new user we have to save in the database
     * @return generated id of the saved user
     */
    @PostMapping("/create")
    public Long createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Returns already saved user information to the client
     *
     * @param id id of the user that the client want to get
     * @return requested user information
     */
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
