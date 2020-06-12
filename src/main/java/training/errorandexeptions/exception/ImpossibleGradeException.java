package training.errorandexeptions.exception;

public class ImpossibleGradeException extends Exception {
    private String message;

    public ImpossibleGradeException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
