package training.errorandexeptions.entity;

public interface Entity {
    default boolean checkId(Integer id) {
        return id != null;
    }
}
