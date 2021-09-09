package gaz.crudtesttask.exceptions;

public class WrongFieldFormatException extends RuntimeException {

    public WrongFieldFormatException() {
        super("Wrong format of fields\n");
    }
}
