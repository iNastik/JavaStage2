package training.errorandexeptions.service;

import training.errorandexeptions.entity.Faculty;
import training.errorandexeptions.entity.Group;
import training.errorandexeptions.entity.Student;
import training.errorandexeptions.entity.Subject;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.exception.SubjectsNotFoundException;
import training.errorandexeptions.repository.SubjectRepository;

public class SubjectService {
    private SubjectRepository subjectRepository = new SubjectRepository();
    private StudentService studentService = new StudentService();
    private GroupService groupService = new GroupService();
    private FacultyService facultyService = new FacultyService();

    public Subject add(Subject subject) {
        return subjectRepository.add(subject);
    }

    public Subject[] getByStudentId(int studentId) throws RepositoryException, SubjectsNotFoundException {
        Student student = studentService.getById(studentId);

        int groupId = student.getGroupId();
        Group group = groupService.getById(groupId);

        int facultyId = group.getFacultyId();
        Faculty faculty = facultyService.getById(facultyId);

        int[] subjectIds = faculty.getSubjectIds();
        if (subjectIds.length == 0) {
            throw new SubjectsNotFoundException("student subjects not found");
        }
        return subjectRepository.getByIds(subjectIds);
    }

    public Subject getByName(String name) throws SubjectsNotFoundException {
        Subject subject = subjectRepository.getByName(name);
        if (subject == null) {
            throw new SubjectsNotFoundException("subject with name " + name + " not found");
        }
        return subject;
    }
}
