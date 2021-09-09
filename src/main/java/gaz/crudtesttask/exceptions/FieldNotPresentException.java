package gaz.crudtesttask.exceptions;

public class FieldNotPresentException extends RuntimeException {

    public FieldNotPresentException() {
        super("Both name and phone number fields must be present.\n");
    }
}
