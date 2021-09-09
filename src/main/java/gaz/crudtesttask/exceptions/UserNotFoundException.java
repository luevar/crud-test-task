package gaz.crudtesttask.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("Can not find user " + id + "\n");
    }
}
