package training.errorandexeptions.service;

import training.errorandexeptions.entity.Faculty;
import training.errorandexeptions.entity.University;
import training.errorandexeptions.exception.FacultiesNotFoundException;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.repository.FacultyRepository;

public class FacultyService {
    private FacultyRepository facultyRepository = new FacultyRepository();
    private UniversityService universityService = new UniversityService();

    public Faculty add(Faculty faculty) {
        return facultyRepository.add(faculty);
    }

    public Faculty getById(int facultyId) throws RepositoryException {
        return facultyRepository.getById(facultyId);
    }

    public Faculty[] getByUniversityId(int universityId) throws RepositoryException, FacultiesNotFoundException {
        University university = universityService.getById(universityId);

        Faculty[] faculties = facultyRepository.getByIds(university.getFacultyIds());

        if (faculties == null) {
            throw new FacultiesNotFoundException("faculties not found");
        }
        return faculties;
    }

    public Faculty getByName(String name) throws FacultiesNotFoundException {
        Faculty faculty = facultyRepository.getByName(name);
        if (faculty == null) {
            throw new FacultiesNotFoundException("faculty with name " + name + " not found");
        }
        return faculty;
    }
}
