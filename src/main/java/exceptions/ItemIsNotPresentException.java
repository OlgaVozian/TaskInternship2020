package exceptions;

public class ItemIsNotPresentException extends RuntimeException {

    public ItemIsNotPresentException(String message) {
        super(message);
    }
}
