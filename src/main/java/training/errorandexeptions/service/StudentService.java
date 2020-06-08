package training.errorandexeptions.service;

import training.errorandexeptions.entity.Group;
import training.errorandexeptions.entity.Student;
import training.errorandexeptions.entity.Subject;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.exception.SubjectsNotFoundException;
import training.errorandexeptions.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public Subject[] getSubjectsByCardId(int cardId) throws SubjectsNotFoundException, RepositoryException {
        Student[] students = studentRepository.getByCardIds(cardId);
        Student student = students[0];

        String groupName = student.getGroupName();
        GroupService groupService = new GroupService();
        Group group = groupService.getByName(groupName);

        Subject[] subjects = group.getFaculty().getSubjects();
        if (subjects == null || subjects.length == 0) {
            throw new SubjectsNotFoundException("student's lack of subjects");
        }
        return subjects;
    }

    public Student[] getStudentsByGroupName(String groupName) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            if(group.getName() == studentList.get(student.getGroup().getName()).toString()) {
                students.add(student);
            }

        }
    }
}
