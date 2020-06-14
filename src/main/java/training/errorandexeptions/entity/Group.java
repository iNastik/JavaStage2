package training.errorandexeptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Group implements Entity {
    @Setter
    private int id;
    @Setter
    private String name;
    private int facultyId;

    public Group(String name, Integer facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }
}
