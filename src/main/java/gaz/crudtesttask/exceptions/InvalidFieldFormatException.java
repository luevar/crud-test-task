package gaz.crudtesttask.exceptions;

public class InvalidFieldFormatException extends RuntimeException {

    public InvalidFieldFormatException() {
        super("Wrong format of fields\n");
    }
}
