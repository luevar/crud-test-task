package gaz.crudtesttask.services;

import gaz.crudtesttask.exceptions.UserNotFoundException;
import gaz.crudtesttask.models.User;
import gaz.crudtesttask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
