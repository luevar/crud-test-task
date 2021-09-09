package gaz.crudtesttask.controllers;

import gaz.crudtesttask.exceptions.FieldNotPresentException;
import gaz.crudtesttask.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller handling application exceptions
 */
@ControllerAdvice
public class UserNotFoundAdvice {
    /**
     * Handles the case of a call to a non-existent user
     *
     * @param ex RuntimeException subclass that marks that requested user not found
     * @return String with error message to the client
     */
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException ex) {
        return ex.getMessage();
    }


    /**
     * Handles the case of creating a new user with missing information
     *
     * @param ex RuntimeException subclass that marks that one of the fields not present
     * @return String with error message to the client
     */
    @ResponseBody
    @ExceptionHandler(FieldNotPresentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String fieldNotPresentHandler(FieldNotPresentException ex) {
        return ex.getMessage();
    }
}
