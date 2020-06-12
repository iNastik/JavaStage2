package training.errorandexeptions.repository;

import training.errorandexeptions.entity.University;
import training.errorandexeptions.exception.RepositoryException;

import java.util.ArrayList;
import java.util.List;

public class UniversityRepository extends Repository {
    private static UniversityRepository instance;

    private UniversityRepository() {
        entityList = new ArrayList<>();
    }

    public static UniversityRepository getInstance() {
        if (instance == null) {
            instance = new UniversityRepository();
        }
        return instance;
    }

    public University add(University university) throws IllegalArgumentException {
        if (university == null) {
            throw new IllegalArgumentException("university can't be null");
        }

        university.setId(entityList.size());
        entityList.add(university);
        return university;
    }

    public void delete(int universityId) throws RepositoryException {
        if (!checkId(universityId)) {
            throw new RepositoryException("university with id " + universityId + " not found");
        }
        entityList.set(universityId, null);
    }

    public University getById(int universityId) throws RepositoryException {
        if (!checkId(universityId)) {
            throw new RepositoryException("university with id " + universityId + " not found");
        }
        return (University) entityList.get(universityId);
    }

    public University[] getByIds(int... universityIds) throws RepositoryException {
        List<University> universities = new ArrayList<>();
        for (int id : universityIds) {
            if (checkId(id)) {
                University university = (University) entityList.get(id);

                if (university != null) {
                    universities.add(university);
                }
            }
        }

        if (universities.isEmpty()) {
            throw new RepositoryException("such universities not found");
        }
        return universities.toArray(new University[0]);
    }

    public void update(University university) throws IllegalArgumentException, RepositoryException {
        if (university == null) {
            throw new IllegalArgumentException("university can't be null");
        }

        if (!checkId(university.getId())) {
            throw new RepositoryException("old university not found");
        }
        entityList.set(university.getId(), university);
    }
}
