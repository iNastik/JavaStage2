package training.errorandexeptions.exception;

public class FacultiesNotFoundException extends Exception {
    String message;
    public FacultiesNotFoundException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
