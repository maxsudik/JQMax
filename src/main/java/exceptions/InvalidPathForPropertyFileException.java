package exceptions;

public final class InvalidPathForPropertyFileException extends FrameworkException {

    public InvalidPathForPropertyFileException(String message) {
        super(message);
    }

    public InvalidPathForPropertyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
