package exceptions;

public class ItemAlreadyInCollectionException extends RuntimeException {

    public ItemAlreadyInCollectionException(String message) {
        super(message);
    }
}
