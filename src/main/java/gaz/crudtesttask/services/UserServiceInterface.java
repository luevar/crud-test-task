package gaz.crudtesttask.services;

import gaz.crudtesttask.models.User;

/**
 * Interface required for implementation by the UserService class to provide a bit more flexibility when adding another services
 */
public interface UserServiceInterface {

    Long createUser(User user);

    User getUser(Long id);
}
