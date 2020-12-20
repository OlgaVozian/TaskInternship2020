package exceptions;

public class ItemNotFoundVideoCollectionException extends RuntimeException{
    public ItemNotFoundVideoCollectionException(String message) {
        super(message);
    }
}
