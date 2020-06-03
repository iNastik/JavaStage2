package training.errorandexeptions.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private List<Subject> subjectList;

    public Faculty(String name, Subject... subjectList) {
        this.name = name;
        this.subjectList = Arrays.asList(subjectList);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void addSubjects(Subject... subjects) {
        subjectList.addAll(Arrays.asList(subjects));
    }

    public void deleteSubjects(Subject... subjects) {
        subjectList.removeAll(Arrays.asList(subjects));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(subjectList, faculty.subjectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjectList);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", subjectList=" + subjectList +
                '}';
    }
}
