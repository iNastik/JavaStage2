package training.errorandexeptions.entity;

import java.util.*;

public class Faculty implements Entity {
    private int id;
    private String name;
    private Set<Integer> subjectIdSet;

    public Faculty(String name, Integer... subjectIds) {
        addSubjects(subjectIds);
        this.name = name;
        this.subjectIdSet = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSubjects(Integer... subjectIds) {
        for (Integer i : subjectIds) {
            checkId(i);
            subjectIdSet.add(i);
        }
    }

    public int[] getSubjectIds() {
        int [] subjectIds = new int [subjectIdSet.size()];
        Integer[] idsFromSet = subjectIdSet.toArray(new Integer[0]);

        for (int i = 0; i < subjectIds.length; i++) {
            subjectIds[i] = idsFromSet[i];
        }
        return subjectIds;
    }

    public void deleteSubjects(int... subjectIds) {
        for (int id : subjectIds) {
            subjectIdSet.remove(id);
        }
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
        Faculty faculty = (Faculty) o;
        return id == faculty.id &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(subjectIdSet, faculty.subjectIdSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subjectIdSet);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subjectIdSet=" + subjectIdSet +
                '}';
    }
}
