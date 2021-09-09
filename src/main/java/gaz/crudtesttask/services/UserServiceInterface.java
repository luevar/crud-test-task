package gaz.crudtesttask.services;

import gaz.crudtesttask.models.User;

public interface UserServiceInterface {

    Long createUser(User user);

    User getUser(Long id);
}
