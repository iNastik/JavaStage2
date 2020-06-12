package training.errorandexeptions.exception;

public class SubjectsNotFoundException extends Exception {
    private String message;

    public SubjectsNotFoundException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
