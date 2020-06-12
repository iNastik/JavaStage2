package training.errorandexeptions.exception;

public class RepositoryException extends Exception {
    private String message;

    public RepositoryException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
