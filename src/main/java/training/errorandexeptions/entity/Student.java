package training.errorandexeptions.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Entity {
    private int id;
    private String name;
    private String surname;
    private int groupId;
    private List<Mark> markList;

    public Student(String surname, String name) {
        this.surname = surname;
        this.name = name;
        markList = new ArrayList<>();
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }

    public Mark[] getMarks() {
        return markList.toArray(new Mark[0]);
    }

    public void addMark(Mark mark) {
        markList.add(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                groupId == student.groupId &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(markList, student.markList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, groupId, markList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupId=" + groupId +
                ", markList=" + markList +
                '}';
    }
}
