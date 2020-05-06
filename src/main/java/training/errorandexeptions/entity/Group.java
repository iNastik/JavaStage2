package training.errorandexeptions.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Group {
    private String name;
    private List<Student> studentList = new ArrayList<>();

    public Group(String name, Student... students) {
        this.name = name;
        studentList.addAll(Arrays.asList(students));
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(studentList, group.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentList);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name=" + name +
                '}';
    }
}
