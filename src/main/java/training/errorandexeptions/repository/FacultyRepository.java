package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Faculty;

import java.util.*;

public class FacultyRepository {
    private Map<String, Faculty> facultyMap;

    public FacultyRepository() {
        facultyMap = new HashMap<>();
    }

    public void add(Faculty faculty) throws IllegalArgumentException, NoSuchElementException {
        if (faculty == null) {
            throw new IllegalArgumentException("faculty can't be null");
        }
        String facultyName = faculty.getName();
        if (!facultyMap.containsKey(facultyName)) {
            throw new NoSuchElementException("Map doesn't contain such faculty name");
        }
        facultyMap.put(facultyName, faculty);
    }

    public void delete(String facultyName) {
        if (facultyName != null && !facultyName.isEmpty()) {
            facultyMap.remove(facultyName);
        }
    }

    public Faculty getByName(String facultyName) throws IllegalArgumentException {
        if (facultyName == null) {
            throw new IllegalArgumentException("name can't be null");
        }
        return facultyMap.get(facultyName);
    }

    public Faculty[] getByNames(String... facultyNames) {
        List<Faculty> faculties = new ArrayList<>();
        for (String facultyName : facultyNames) {
            Faculty faculty = facultyMap.get(facultyName);
            if (faculty != null) {
                faculties.add(faculty);
            }
        }
        return faculties.toArray(new Faculty[0]);
    }

    public Faculty[] getAll() {
        return facultyMap.values().toArray(new Faculty[0]);
    }

    public void update(Faculty faculty) throws IllegalArgumentException {
        if (faculty == null) {
            throw new IllegalArgumentException("faculty can't be null");
        }
        String facultyName = faculty.getName();
        if (facultyMap.containsKey(facultyName)) {
            facultyMap.put(facultyName, faculty);
        }
    }
}
