package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Entity;
import training.errorandexeptions.entity.Student;
import training.errorandexeptions.exception.RepositoryException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository extends Repository {

    public StudentRepository() {
        entityList = new ArrayList<>();
    }

    public Student add(Student student) throws IllegalArgumentException {
        if (student == null) {
            throw new IllegalArgumentException("student can't be null");
        }

        student.setId(entityList.size());
        entityList.add(student);
        return student;
    }

    public void delete(int studentId) throws RepositoryException {
        if (!checkId(studentId)) {
            throw new RepositoryException("student with id " + studentId + " not found");
        }
        entityList.set(studentId, null);
    }

    public Student getById(int studentId) throws RepositoryException {
        if (!checkId(studentId)) {
            throw new RepositoryException("student with id " + studentId + " not found");
        }
        return (Student) entityList.get(studentId);
    }

    public Student[] getByIds(int... studentIds) throws RepositoryException {
        List<Student> students = new ArrayList<>();
        for (int id : studentIds) {
            if (checkId(id)) {
                Student student = (Student) entityList.get(id);

                if (student != null) {
                    students.add(student);
                }
            }
        }

        if (students.isEmpty()) {
            throw new RepositoryException("such students not found");
        }
        return students.toArray(new Student[0]);
    }

    public Student[] getByGroupId(int groupId) {
        List<Student> studentList = new ArrayList<>();
        for (Entity entity : entityList) {
            Student student = (Student) entity;
            if (student.getGroupId() == groupId) {
                studentList.add(student);
            }
        }
        return studentList.toArray(new Student[0]);
    }

    public Student[] getByGroupIds(Integer... groupIds) {
        List<Student> studentList = new ArrayList<>();
        for (Integer id : groupIds) {
            studentList.addAll(Arrays.asList(getByGroupId(id)));
        }
        return studentList.toArray(new Student[0]);
    }

    public void update(Student student) throws IllegalArgumentException, RepositoryException {
        if (student == null) {
            throw new IllegalArgumentException("student can't be null");
        }

        if (!checkId(student.getId())) {
            throw new RepositoryException("old student not found");
        }
        entityList.set(student.getId(), student);
    }
}
