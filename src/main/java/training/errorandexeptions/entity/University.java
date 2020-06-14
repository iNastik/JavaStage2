package training.errorandexeptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class University implements Entity {
    @Setter
    @Getter
    private int id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String info;
    private Set<Integer> studentIdSet;
    private Set<Integer> facultyIdSet;
    private Set<Integer> groupIdSet;

    public University(String name, String info, Integer... facultyIds) {
        this.name = name;
        this.info = info;
        facultyIdSet = new HashSet<>();
        addFaculties(facultyIds);
        studentIdSet = new HashSet<>();
        groupIdSet = new HashSet<>();
    }

    public int[] getFacultyIds() {
        int[] facultyIds = new int[facultyIdSet.size()];
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
        int[] studentIds = new int[studentIdSet.size()];
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

    public int[] getGroupIds() {
        int[] groupIds = new int[groupIdSet.size()];
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
}

