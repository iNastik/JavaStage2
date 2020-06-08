package training.errorandexeptions.exception;

public class RepositoryException extends Exception{
    String message;

    public RepositoryException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
