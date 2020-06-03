package training.errorandexeptions.repository;

import training.errorandexeptions.entity.University;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityRepository {
    private Map<String, University> universityMap;

    public UniversityRepository() {
        universityMap = new HashMap<>();
    }

    public void addUniversity(String universityName, University university) {
        if (universityMap.containsKey(universityName)) {
            // TODO: 03.06.2020 throws exceptions
        }
        universityMap.put(universityName, university);
    }

    public void deleteUniversity(String universityName) {
        universityMap.remove(universityName);
    }

    public University[] getUniversitiesByNames(String... universityNames) {
        List<University> universities = new ArrayList<>();
        for (String universityName : universityNames) {
            University university = universityMap.get(universityName);
            if (university != null) {
                universities.add(university);
            }
        }
        return universities.toArray(new University[0]);
    }

    public Object[] getAllUniversities() {
        return universityMap.values().toArray();
    }
}
