package training.errorandexeptions.entity;

import java.util.Objects;

public class Mark {
    private int grade;
    private Subject subject;

    public Mark(int grade, Subject subject) {
        this.grade = grade;
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return grade == mark1.grade &&
                Objects.equals(subject, mark1.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, subject);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "mark=" + grade +
                ", subject=" + subject +
                '}';
    }
}
