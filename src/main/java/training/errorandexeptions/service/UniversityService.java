package training.errorandexeptions.service;

import training.errorandexeptions.entity.University;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.repository.UniversityRepository;

public class UniversityService {
    private UniversityRepository universityRepository = new UniversityRepository();

    public University add(University university) {
        return universityRepository.add(university);
    }

    public University getById(int universityId) throws RepositoryException {
        return universityRepository.getById(universityId);
    }

}
