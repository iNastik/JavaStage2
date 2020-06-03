package training.errorandexeptions;

import training.errorandexeptions.entity.*;

public class Main {

    public static void main(String[] args) {
        University bsaaUniversity = new University("Belarusian State Academy of Arts",
                "Art, science and culture.", initBsaaFaculties());

        bsaaUniversity.addStudents(initBsaaStudents());
        bsaaUniversity.addSubjects(initBsaaSubjects());
        bsaaUniversity.addGroups(initBsaaGroups());
    }

    private static Student[] initBsaaStudents() {
        return new Student[]{
                new Student("Hohlova", "Alina"),
                new Student("Rogova", "Irina"),
                new Student("Orlov", "Denis"),
                new Student("Pirogova", "Anna"),
                new Student("Kot", "Alina"),
                new Student("Minin", "Viktor"),
                new Student("Popov", "Lev"),
                new Student("Kolos", "Inna"),
                new Student("Dom", "Kirill"),
                new Student("Losik", "Vitali"),
                new Student("Gordova", "LiLia"),
                new Student("Malik", "Tatiana"),
                new Student("Reh", "Helena"),
                new Student("Zolotova", "Arina"),
                new Student("Tik", "Faina"),
                new Student("Repin", "Igor"),
                new Student("Lim", "Kim"),
                new Student("Luk", "Natalia"),
                new Student("Korobov", "Pavel"),
                new Student("Saharov", "Anton"),
                new Student("Babina", "Margarita")
        };
    }

    private static Subject[] initBsaaSubjects() {
        return new Subject[]{
                new Subject("Painting"),
                new Subject("Acting"),
                new Subject("Economic"),
                new Subject("Decorative art"),
                new Subject("Design"),
                new Subject("Sculpture"),
                new Subject("Psychology")
        };
    }

    private static Faculty[] initBsaaFaculties(Subject[] subjects) {
        return new Faculty[]{
                new Faculty("Theatre", subjects[1], subjects[2], subjects[6]),
                new Faculty("Art", subjects[1], subjects[2], subjects[3], subjects[6]),
                new Faculty("Design", subjects[0], subjects[2], subjects[4], subjects[5])
        };
    }

    private static Group[] initBsaaGroups(Faculty faculty) {
        return new Group[]{
                new Group("24"),
                new Group("26"),
                new Group("27"),
                new Group("33"),
                new Group("35"),
                new Group("38"),
                new Group("42"),
                new Group("44"),
                new Group("45")
        };
    }
}

