package training.errorandexeptions.repository;

import training.errorandexeptions.entity.Student;

import java.util.*;

public class StudentRepository {
    private Map<Integer, Student> studentMap;

    public StudentRepository() {
        studentMap = new HashMap<>();
    }

    public void add(Student student) throws IllegalArgumentException, NoSuchElementException {
        if (student == null) {
            throw new IllegalArgumentException("student can't be null");
        }
        int cardId = student.getCardId();
        if (!studentMap.containsKey(cardId)) {
            throw new NoSuchElementException("Map doesn't contain such card ID");
        }
        studentMap.put(cardId, student);
    }

    public void delete(int cardId) {
        studentMap.remove(cardId);
    }

    public Student[] getByCardIds(int... cardIds) {
        List<Student> students = new ArrayList<>();
        for (int cardId : cardIds) {
            Student student = studentMap.get(cardId);
            if (student != null) {
                students.add(student);
            }
        }
        return students.toArray(new Student[0]);
    }

    public Student[] getAll() {
        return studentMap.values().toArray(new Student[0]);
    }

    public void update(Student student) throws IllegalArgumentException{
        if (student == null) {
            throw new IllegalArgumentException("student can't be null");
        }
        int cardId = student.getCardId();
        if (studentMap.containsKey(cardId)) {
            studentMap.put(cardId, student);
        }
    }
}
