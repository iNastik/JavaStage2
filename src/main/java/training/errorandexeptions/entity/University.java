package training.errorandexeptions.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    private String info;
    private List<Faculty> facultyList = new ArrayList<>();

    public University(Faculty... faculties) {
        this.name = name;
        this.info = info;
        facultyList.addAll(Arrays.asList(faculties));
    }

    public Faculty[] getFaculties() {
        return facultyList.toArray(new Faculty[0]);
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
                Objects.equals(facultyList, that.facultyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info, facultyList);
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", facultyList=" + facultyList +
                '}';
    }
}
