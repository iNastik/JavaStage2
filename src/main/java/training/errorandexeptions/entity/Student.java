package training.errorandexeptions.entity;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private String surname;
    private Group group;
    private List<Mark> markList;

    public Student(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }

    public List<Mark> getMarks() {
        return markList;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(group, student.group) &&
                Objects.equals(markList, student.markList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, group, markList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group=" + group +
                ", markList=" + markList +
                '}';
    }
}
