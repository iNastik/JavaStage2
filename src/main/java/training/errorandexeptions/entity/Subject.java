package training.errorandexeptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Subject implements Entity {
    private int id;
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}
