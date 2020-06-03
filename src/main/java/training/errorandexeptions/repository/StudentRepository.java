package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentMap;

    public StudentRepository() {
        studentMap = new HashMap<>();
    }

    public void addStudent(String cardId, Student student) {
        if (studentMap.containsKey(cardId)) {
            // TODO: 03.06.2020 throws exceptions
        }
        studentMap.put(cardId, student);
    }

    public void deleteStudent(String cardId) {
        studentMap.remove(cardId);
    }

    public Student[] getStudentsByNames(String... cardIds) {
        List<Student> students = new ArrayList<>();
        for (String cardId : cardIds) {
            Student student = studentMap.get(cardId);
            if (student != null) {
                students.add(student);
            }
        }
        return students.toArray(new Student[0]);
    }

    public Student[] getAllStudents() {
        return studentMap.values().toArray(new Student[0]);
    }
}
