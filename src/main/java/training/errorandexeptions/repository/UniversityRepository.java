package training.errorandexeptions.repository;

import training.errorandexeptions.entity.University;

import java.util.*;

public class UniversityRepository {
    private Map<String, University> universityMap;

    public UniversityRepository() {
        universityMap = new HashMap<>();
    }

    public void add(University university) throws IllegalArgumentException, NoSuchElementException {
        if (university == null) {
            throw new IllegalArgumentException("university can't be null");
        }
        String universityName = university.getName();
        if (!universityMap.containsKey(universityName)) {
            throw new NoSuchElementException("Map doesn't contain such university name");
        }
        universityMap.put(universityName, university);
    }

    public void delete(String universityName) {
        if (universityName != null && !universityName.isEmpty()) {
            universityMap.remove(universityName);
        }
    }

    public University[] getByNames(String... universityNames) {
        List<University> universities = new ArrayList<>();
        for (String universityName : universityNames) {
            University university = universityMap.get(universityName);
            if (university != null) {
                universities.add(university);
            }
        }
        return universities.toArray(new University[0]);
    }

    public University[] getAll() {
        return universityMap.values().toArray(new University[0]);
    }

    public void update(University university) throws IllegalArgumentException{
        if (university == null) {
            throw new IllegalArgumentException("university can't be null");
        }
        String universityName = university.getName();
        if (universityMap.containsKey(universityName)) {
            universityMap.put(universityName, university);
        }
    }
}
