package training.errorandexeptions.exception;

public class GroupsNotFoundException extends Exception {
    private String message;

    public GroupsNotFoundException(String str) {
        message = str;
    }

    public String toString() {
        return (message);
    }
}
