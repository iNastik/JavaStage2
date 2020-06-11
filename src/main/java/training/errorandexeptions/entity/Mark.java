package training.errorandexeptions.entity;

import training.errorandexeptions.exception.ImpossibleGradeException;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.repository.SubjectRepository;

import java.util.Objects;

public class Mark {
    private int grade;
    private int subjectId;

    public Mark(int grade, int subjectId) throws IllegalArgumentException, ImpossibleGradeException, RepositoryException {
        if (grade < 0 || grade > 10) {
            throw new ImpossibleGradeException("grade must have a value from 0 to 10");
        }

        SubjectRepository subjectRepository = new SubjectRepository();
        Subject subject = subjectRepository.getById(subjectId);

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return grade == mark1.grade &&
                Objects.equals(subjectId, mark1.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, subjectId);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mark=" + grade +
                ", subject=" + subjectId +
                '}';
    }
}
