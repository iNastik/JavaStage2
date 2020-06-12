package training.errorandexeptions.entity;

import training.errorandexeptions.exception.ImpossibleGradeException;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.exception.SubjectsNotFoundException;
import training.errorandexeptions.service.SubjectService;

import java.util.Objects;

public class Mark {
    private int grade;
    private int subjectId;

    public Mark(int grade, int subjectId) throws IllegalArgumentException, ImpossibleGradeException, RepositoryException,
            SubjectsNotFoundException {
        if (grade < 0 || grade > 10) {
            throw new ImpossibleGradeException("grade must have a value from 0 to 10");
        }

        SubjectService subjectService = new SubjectService();
        Subject subject = subjectService.getById(subjectId);

        if (subject == null) {
            throw new IllegalArgumentException("no such subject");
        }

        this.grade = grade;
        this.subjectId = subjectId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return grade == mark.grade &&
                subjectId == mark.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, subjectId);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "grade=" + grade +
                ", subjectId=" + subjectId +
                '}';
    }
}
