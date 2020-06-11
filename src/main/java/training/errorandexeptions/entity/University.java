package training.errorandexeptions.entity;

import java.util.*;

public class University implements Entity {
    private int id;
    private String name;
    private String info;
    private Set<Integer> studentIdSet;
    private Set<Integer> facultyIdSet;
    private Set<Integer> subjectIdSet;
    private Set<Integer> groupIdSet;

    public University(String name, String info, Integer... facultyIds) {
        this.name = name;
        this.info = info;
        facultyIdSet = new HashSet<>();
        addFaculties(facultyIds);
        studentIdSet = new HashSet<>();
        subjectIdSet = new HashSet<>();
        groupIdSet = new HashSet<>();
    }

    public int[] getFacultyIds() {
        int [] facultyIds = new int [facultyIdSet.size()];
        Integer[] idsFromSet = facultyIdSet.toArray(new Integer[0]);

        for (int i = 0; i < facultyIds.length; i++) {
            facultyIds[i] = idsFromSet[i];
        }
        return facultyIds;
    }

    public void addFaculties(Integer... facultyIds) {
        for (Integer id : facultyIds) {
            checkId(id);
            facultyIdSet.add(id);
        }
    }

    public void deleteFaculty(int facultyId) {
        facultyIdSet.remove(facultyId);
    }

    public int[] getStudentIds() {
        int [] studentIds = new int [studentIdSet.size()];
        Integer[] idsFromSet = studentIdSet.toArray(new Integer[0]);

        for (int i = 0; i < studentIds.length; i++) {
            studentIds[i] = idsFromSet[i];
        }
        return studentIds;
    }

    public void addStudents(Integer... studentIds) {
        for (Integer id : studentIds) {
            checkId(id);
            studentIdSet.add(id);
        }
    }

    public void deleteStudents(int... studentIds) {
        for (int id : studentIds) {
            studentIdSet.remove(id);
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

    public void addSubjects(Integer... subjectIds) {
        for (Integer id : subjectIds) {
            checkId(id);
            subjectIdSet.add(id);
        }
    }

    public void deleteSubjects(int... subjectIds) {
        for (int id : subjectIds) {
            subjectIdSet.remove(id);
        }
    }

    public int[] getGroupIds() {
        int [] groupIds = new int [groupIdSet.size()];
        Integer[] idsFromSet = groupIdSet.toArray(new Integer[0]);

        for (int i = 0; i < groupIds.length; i++) {
            groupIds[i] = idsFromSet[i];
        }
        return groupIds;
    }

    public void addGroups(Integer... groupIds) {
        for (Integer id : groupIds) {
            checkId(id);
            groupIdSet.add(id);
        }
    }

    public void deleteGroups(int... groupIds) {
        for (int id : groupIds) {
            groupIdSet.remove(id);
        }
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
        University that = (University) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(info, that.info) &&
                Objects.equals(studentIdSet, that.studentIdSet) &&
                Objects.equals(facultyIdSet, that.facultyIdSet) &&
                Objects.equals(subjectIdSet, that.subjectIdSet) &&
                Objects.equals(groupIdSet, that.groupIdSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info, studentIdSet, facultyIdSet, subjectIdSet, groupIdSet);
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", studentIdSet=" + studentIdSet +
                ", facultyIdSet=" + facultyIdSet +
                ", subjectIdSet=" + subjectIdSet +
                ", groupIdSet=" + groupIdSet +
                '}';
    }
}

