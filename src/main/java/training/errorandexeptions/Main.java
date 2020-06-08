package training.errorandexeptions;

import training.errorandexeptions.entity.*;
import training.errorandexeptions.repository.*;

public class Main {
    UniversityRepository universityRepository = new UniversityRepository();
    FacultyRepository facultyRepository = new FacultyRepository();
    StudentRepository studentRepository = new StudentRepository();
    SubjectRepository subjectRepository = new SubjectRepository();
    GroupRepository groupRepository = new GroupRepository();

    public static void main(String[] args) {

    }

    private void initUniversities() {
        universityRepository.add(new University("Belarusian State Academy of Arts",
                "Art, science and culture.", facultyRepository.getAll()));
    }

    private void initStudents() {
        studentRepository.add(new Student(40471, "Hohlova", "Alina"));
        studentRepository.add(new Student(40472, "Rogova", "Irina"));
        studentRepository.add(new Student(40473, "Orlov", "Denis"));
        studentRepository.add(new Student(40475, "Pirogova", "Anna"));
        studentRepository.add(new Student(40479, "Kot", "Alina"));
        studentRepository.add(new Student(40480, "Minin", "Viktor"));
        studentRepository.add(new Student(40481, "Popov", "Lev"));
        studentRepository.add(new Student(40483, "Kolos", "Inna"));
        studentRepository.add(new Student(40484, "Dom", "Kirill"));
        studentRepository.add(new Student(40485, "Losik", "Vitali"));
        studentRepository.add(new Student(40486, "Gordova", "LiLia"));
        studentRepository.add(new Student(40487, "Malik", "Tatiana"));
        studentRepository.add(new Student(40488, "Reh", "Helena"));
        studentRepository.add(new Student(40489, "Zolotova", "Arina"));
        studentRepository.add(new Student(40490, "Tik", "Faina"));
        studentRepository.add(new Student(40491, "Repin", "Igor"));
        studentRepository.add(new Student(40492, "Lim", "Kim"));
        studentRepository.add(new Student(40493, "Luk", "Natalia"));
        studentRepository.add(new Student(40494, "Korobov", "Pavel"));
        studentRepository.add(new Student(40495, "Saharov", "Anton"));
        studentRepository.add(new Student(40497, "Babina", "Margarita"));
    }

    private void initSubjects() {
        subjectRepository.add(new Subject("Painting"));
        subjectRepository.add(new Subject("Acting"));
        subjectRepository.add(new Subject("Economic"));
        subjectRepository.add(new Subject("Decorative art"));
        subjectRepository.add(new Subject("Design"));
        subjectRepository.add(new Subject("Sculpture"));
        subjectRepository.add(new Subject("Psychology"));
    }

    private void initFaculties() {
        facultyRepository.add(new Faculty("Theatre", subjectRepository.getByNames(
                "Acting", "Economic", "Psychology")));
        facultyRepository.add(new Faculty("Art", subjectRepository.getByNames(
                "Painting", "Economic", "Decorative art", "Sculpture")));
        facultyRepository.add(new Faculty("Design", subjectRepository.getByNames(
                "Painting", "Economic", "Decorative art", "Design")));
    }

    private void initGroups() {
        groupRepository.add(new Group("24", facultyRepository.getByName("Theatre")));
        groupRepository.add(new Group("26", facultyRepository.getByName("Theatre")));
        groupRepository.add(new Group("27", facultyRepository.getByName("Theatre")));
        groupRepository.add(new Group("33", facultyRepository.getByName("Art")));
        groupRepository.add(new Group("35", facultyRepository.getByName("Art")));
        groupRepository.add(new Group("38", facultyRepository.getByName("Art")));
        groupRepository.add(new Group("42", facultyRepository.getByName("Design")));
        groupRepository.add(new Group("44", facultyRepository.getByName("Design")));
        groupRepository.add(new Group("45", facultyRepository.getByName("Design")));
    }
}

