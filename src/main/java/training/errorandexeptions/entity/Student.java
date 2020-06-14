package training.errorandexeptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
public class Student implements Entity {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private String surname;
    @Getter
    private int groupId;
    private List<Mark> markList;

    public Student(String surname, String name) {
        this.surname = surname;
        this.name = name;
        markList = new ArrayList<>();
    }

    public Mark[] getMarks() {
        return markList.toArray(new Mark[0]);
    }

    public void addMark(Mark mark) {
        markList.add(mark);
    }
}
