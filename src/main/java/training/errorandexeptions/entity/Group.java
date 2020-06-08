package training.errorandexeptions.entity;

import java.util.Objects;

public class Group {
    private String name;
    private Faculty faculty;

    public Group(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(faculty, group.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculty);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", faculty=" + faculty +
                '}';
    }

}
