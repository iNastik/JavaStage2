package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectRepository {
    Map<String, Subject> subjectMap;

    public SubjectRepository() {
        subjectMap = new HashMap<>();
    }

    public void addSubject(String subjectName, Subject subject) {
        if (subjectMap.containsKey(subjectName)) {
            // TODO: 03.06.2020 throws exceptions
        }
        subjectMap.put(subjectName, subject);
    }

    public void deleteSubject(String subjectName) {
        subjectMap.remove(subjectName);
    }

    public Subject[] getSubjectsByNames(String... subjectNames) {
        List<Subject> subjects = new ArrayList<>();
        for (String subjectName : subjectNames) {
            Subject subject = subjectMap.get(subjectName);
            if (subject != null) {
                subjects.add(subject);
            }
        }
        return subjects.toArray(new Subject[0]);
    }

    public Subject[] getAllSubjects() {
        return subjectMap.values().toArray(new Subject[0]);
    }
}
