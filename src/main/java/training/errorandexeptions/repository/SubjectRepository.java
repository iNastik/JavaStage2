package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Entity;
import training.errorandexeptions.entity.Subject;
import training.errorandexeptions.exception.RepositoryException;

import java.util.ArrayList;
import java.util.List;

public class SubjectRepository extends Repository {

    public SubjectRepository() {
        entityList = new ArrayList<>();
    }

    public Subject add(Subject subject) throws IllegalArgumentException {
        if (subject == null) {
            throw new IllegalArgumentException("subject can't be null");
        }

        subject.setId(entityList.size());
        entityList.add(subject);
        return subject;
    }

    public void delete(int subjectId) throws RepositoryException {
        if (!checkId(subjectId)) {
            throw new RepositoryException("subject with id " + subjectId + " not found");
        }
        entityList.set(subjectId, null);
    }

    public Subject getById(int subjectId) throws RepositoryException {
        if (!checkId(subjectId)) {
            throw new RepositoryException("subject with id " + subjectId + " not found");
        }
        return (Subject) entityList.get(subjectId);
    }

    public Subject[] getByIds(int[] subjectIds) throws RepositoryException {
        List<Subject> subjects = new ArrayList<>();
        for (int id : subjectIds) {
            if (checkId(id)) {
                Subject subject = (Subject) entityList.get(id);

                if (subject != null) {
                    subjects.add(subject);
                }
            }
        }

        if (subjects.isEmpty()) {
            throw new RepositoryException("such subjects not found");
        }
        return subjects.toArray(new Subject[0]);
    }

    public void update(Subject subject) throws IllegalArgumentException, RepositoryException {
        if (subject == null) {
            throw new IllegalArgumentException("subject can't be null");
        }

        if (!checkId(subject.getId())) {
            throw new RepositoryException("old subject not found");
        }
        entityList.set(subject.getId(), subject);
    }

    public Subject getByName(String name) {
        Subject subject = null;
        for (Entity entity : entityList) {
            Subject s = (Subject) entity;
            if (s.getName().equals(name)) {
                subject = s;
            }
        }
        return subject;
    }
}
