package gaz.crudtesttask.services;

import gaz.crudtesttask.exceptions.UserNotFoundException;
import gaz.crudtesttask.exceptions.InvalidFieldFormatException;
import gaz.crudtesttask.models.User;
import gaz.crudtesttask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Service class to implement business logic (mostly in the future)
 */
@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Saves the new user passed from the client
     *
     * @param user the new user we have to save in the database
     * @return generated id of the saved user
     */
    @Override
    public Long createUser(User user) {
        Pattern namePattern = Pattern.compile("^[a-zA-Zа-яА-Я ]*$");
        Pattern phoneNumberPattern = Pattern.compile("^\\+?\\d{11}$");
        if (!namePattern.matcher(user.getName()).matches()
                || !phoneNumberPattern.matcher(user.getPhoneNumber()).matches()) {
            throw new InvalidFieldFormatException();
        }
        return userRepository.save(user).getId();
    }

    /**
     * Returns already saved user information to the client
     *
     * @param id id of the user that the client want to get
     * @return requested user information or else throw UserNotFoundException
     */
    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
