package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacultyRepository {
    private Map<String, Faculty> facultyMap;

    public FacultyRepository() {
        facultyMap = new HashMap<>();
    }

    public void addFaculty(String facultyName, Faculty faculty) {
        if (facultyMap.containsKey(facultyName)) {
            // TODO: 02.06.2020 throws exceptions
        }
        facultyMap.put(facultyName, faculty);
    }

    public void deleteFaculty(String facultyName) {
        facultyMap.remove(facultyName);
    }

    public Faculty[] getFacultiesByNames(String... facultyNames) {
        List<Faculty> faculties = new ArrayList<>();
        for (String facultyName : facultyNames) {
            Faculty faculty = facultyMap.get(facultyName);
            if (faculty != null) {
                faculties.add(faculty);
            }
        }
        return faculties.toArray(new Faculty[0]);
    }

    public Object[] getAllFaculties() {
        return facultyMap.values().toArray();
    }
}
