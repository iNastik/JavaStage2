package training.errorandexeptions.service;

import training.errorandexeptions.entity.Student;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.exception.StudentsNotFoundException;
import training.errorandexeptions.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository = StudentRepository.getInstance();

    public Student add(Student student) {
        return studentRepository.add(student);
    }

    public Student getById(int studentId) throws RepositoryException {
        return studentRepository.getById(studentId);
    }

    public Student[] getByGroupId(int groupId) throws StudentsNotFoundException {
        Student[] students = studentRepository.getByGroupId(groupId);

        if (students.length == 0) {
            throw new StudentsNotFoundException("students not found");
        }
        return students;
    }

    public Student[] getByGroupIds(Integer... groupIds) throws StudentsNotFoundException {
        Student[] students = studentRepository.getByGroupIds(groupIds);
        if (students.length == 0) {
            throw new StudentsNotFoundException("students not found");
        }
        return students;
    }
}
