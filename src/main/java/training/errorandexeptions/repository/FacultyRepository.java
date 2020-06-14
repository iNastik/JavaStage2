package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Entity;
import training.errorandexeptions.entity.Faculty;
import training.errorandexeptions.exception.RepositoryException;

import java.util.ArrayList;
import java.util.List;

public class FacultyRepository extends Repository {
    private static FacultyRepository instance;

    private FacultyRepository() {
        entityList = new ArrayList<>();
    }

    public static FacultyRepository getInstance() {
        if (instance == null) {
            instance = new FacultyRepository();
        }
        return instance;
    }

    public Faculty add(Faculty faculty) throws IllegalArgumentException {
        if (faculty == null) {
            throw new IllegalArgumentException("faculty can't be null");
        }
        faculty.setId(entityList.size());
        entityList.add(faculty);
        return faculty;
    }

    public void delete(int facultyId) throws RepositoryException {
        if (!checkId(facultyId)) {
            throw new RepositoryException("faculty with id " + facultyId + " not found");
        }
        entityList.set(facultyId, null);
    }

    public Faculty getById(int facultyId) throws RepositoryException {
        if (!checkId(facultyId)) {
            throw new RepositoryException("faculty with id " + facultyId + " not found");
        }
        return (Faculty) entityList.get(facultyId);
    }

    public Faculty[] getByIds(int... facultyIds) throws RepositoryException {
        List<Faculty> faculties = new ArrayList<>();

        for (int id : facultyIds) {
            if (checkId(id)) {
                Faculty faculty = (Faculty) entityList.get(id);
                if (faculty != null) {
                    faculties.add(faculty);
                }
            }
        }

        if (faculties.isEmpty()) {
            throw new RepositoryException("such faculties not found");
        }
        return faculties.toArray(new Faculty[0]);
    }

    public Faculty getByName(String name) {
        Faculty faculty = null;
        for (Entity entity : entityList) {
            Faculty f = (Faculty) entity;
            if (f.getName().equals(name)) {
                faculty = f;
            }
        }
        return faculty;
    }

    public void update(Faculty faculty) throws IllegalArgumentException, RepositoryException {
        if (faculty == null) {
            throw new IllegalArgumentException("faculty can't be null");
        }

        if (!checkId(faculty.getId())) {
            throw new RepositoryException("old faculty not found");
        }
        entityList.set(faculty.getId(), faculty);
    }
}
