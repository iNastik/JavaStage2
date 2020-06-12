package training.errorandexeptions.exception;

public class StudentsNotFoundException extends Exception {
    private String message;

    public StudentsNotFoundException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
