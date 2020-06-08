package training.errorandexeptions.exception;

public class SubjectsNotFoundException extends Exception{
    String message;

    public SubjectsNotFoundException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
