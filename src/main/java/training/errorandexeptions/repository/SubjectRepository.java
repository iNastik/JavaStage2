package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Faculty;
import training.errorandexeptions.entity.Subject;

import java.util.*;

public class SubjectRepository {
    Map<String, Subject> subjectMap;

    public SubjectRepository() {
        subjectMap = new HashMap<>();
    }

    public void add(Subject subject) throws IllegalArgumentException, NoSuchElementException{
        if (subject == null) {
            throw new IllegalArgumentException("subject can't be null");
        }
        String subjectName = subject.getName();
        if (!subjectMap.containsKey(subjectName)) {
            throw new NoSuchElementException("Map doesn't contain such subject name");
        }
        subjectMap.put(subjectName, subject);
    }

    public void delete(String subjectName) {
        if (subjectName != null && !subjectName.isEmpty()) {
            subjectMap.remove(subjectName);
        }
    }

    public Subject getByName(String subjectName) throws IllegalArgumentException {
        if (subjectName == null) {
            throw new IllegalArgumentException("name can't be null");
        }
        return subjectMap.get(subjectName);
    }

    public Subject[] getByNames(String... subjectNames) {
        List<Subject> subjects = new ArrayList<>();
        for (String subjectName : subjectNames) {
            Subject subject = subjectMap.get(subjectName);
            if (subject != null) {
                subjects.add(subject);
            }
        }
        return subjects.toArray(new Subject[0]);
    }

    public Subject[] getAll() {
        return subjectMap.values().toArray(new Subject[0]);
    }

    public void update(Subject subject) throws IllegalArgumentException {
        if (subject == null) {
            throw new IllegalArgumentException("subject can't be null");
        }
        String subjectName = subject.getName();
        if (subjectMap.containsKey(subjectName)) {
            subjectMap.put(subjectName, subject);
        }
    }
}
