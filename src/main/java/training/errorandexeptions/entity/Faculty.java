package training.errorandexeptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class Faculty implements Entity {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;
    private Set<Integer> subjectIdSet;

    public Faculty(String name, Integer... subjectIds) {
        this.name = name;
        this.subjectIdSet = new HashSet<>();
        addSubjects(subjectIds);
    }

    public void addSubjects(Integer... subjectIds) {
        for (Integer i : subjectIds) {
            checkId(i);
            subjectIdSet.add(i);
        }
    }

    public int[] getSubjectIds() {
        int[] subjectIds = new int[subjectIdSet.size()];
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
}
