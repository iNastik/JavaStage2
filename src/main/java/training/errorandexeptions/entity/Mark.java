package training.errorandexeptions.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import training.errorandexeptions.exception.ImpossibleGradeException;
import training.errorandexeptions.exception.RepositoryException;
import training.errorandexeptions.exception.SubjectsNotFoundException;
import training.errorandexeptions.service.SubjectService;

@EqualsAndHashCode
@ToString
@Setter
@Getter
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
}
