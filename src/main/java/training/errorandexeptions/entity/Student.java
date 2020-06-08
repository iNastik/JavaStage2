package training.errorandexeptions.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private int cardId;
    private String name;
    private String surname;
    private String groupName;
    private List<Mark> markList;

    public Student(int cardId, String surname, String name) {
        this.cardId = cardId;
        this.surname = surname;
        this.name = name;
        markList = new ArrayList<>();
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

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return cardId == student.cardId &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(groupName, student.groupName) &&
                Objects.equals(markList, student.markList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, name, surname, groupName, markList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "cardId=" + cardId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupName='" + groupName + '\'' +
                ", markList=" + markList +
                '}';
    }
}
