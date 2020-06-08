package training.errorandexeptions.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private String info;
    private List<Student> studentList;
    private List<Faculty> facultyList;
    private List<Subject> subjectList;
    private List<Group> groupList;

    public University(String name, String info, Faculty ... faculties) {
        this.name = name;
        this.info = info;
        facultyList = new ArrayList<>();
        facultyList.addAll(Arrays.asList(faculties));
        studentList = new ArrayList<>();
        subjectList = new ArrayList<>();
        groupList = new ArrayList<>();
    }

    public List<Faculty> getFaculties() {
        return facultyList;
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public void deleteFaculty(Faculty faculty) {
        facultyList.remove(faculty);
    }

    public void addStudents(Student... students) {
        studentList.addAll(Arrays.asList(students));
    }

    public void deleteStudents(Student... students) {
        studentList.removeAll(Arrays.asList(students));
    }

    public void addSubjects(Subject... subjects) {
        subjectList.addAll(Arrays.asList(subjects));
    }

    public void deleteSubjects(Subject... subjects) {
        subjectList.removeAll(Arrays.asList(subjects));
    }

    public void addGroups(Group... groups) {
        groupList.addAll(Arrays.asList(groups));
    }

    public void deleteGroups(Group... groups) {
        groupList.removeAll(Arrays.asList(groups));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(info, that.info) &&
                Objects.equals(studentList, that.studentList) &&
                Objects.equals(facultyList, that.facultyList) &&
                Objects.equals(subjectList, that.subjectList) &&
                Objects.equals(groupList, that.groupList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info, studentList, facultyList, subjectList, groupList);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", studentList=" + studentList +
                ", facultyList=" + facultyList +
                ", subjectList=" + subjectList +
                ", groupList=" + groupList +
                '}';
    }
}

