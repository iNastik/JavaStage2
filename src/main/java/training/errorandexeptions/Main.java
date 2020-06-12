package training.errorandexeptions;

import training.errorandexeptions.entity.*;
import training.errorandexeptions.exception.*;
import training.errorandexeptions.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static UniversityService universityService = new UniversityService();
    static FacultyService facultyService = new FacultyService();
    static GroupService groupService = new GroupService();
    static StudentService studentService = new StudentService();
    static SubjectService subjectService = new SubjectService();

    static final int REPIN_STUDENT_ID = 4;
    static final int ACTING_SUBJECT_ID = 1;
    static final int TWENTY_FOUR_GROUP_ID = 0;
    static final int DESIGN_SUBJECT_ID = 4;
    static final int DESIGN_FACULTY_ID = 1;
    static final int ECONOMIC_SUBJECT_ID = 2;

    public static void main(String[] args) throws SubjectsNotFoundException, FacultiesNotFoundException,
            ImpossibleGradeException, RepositoryException, StudentsNotFoundException, GroupsNotFoundException {
        initSubjects();
        University bsaa = initBsaaUniversity();

        System.out.println("Repin average mark is " + getStudentAverageMark(REPIN_STUDENT_ID));

        System.out.println("Average mark in Acting in 24 group is " + getStudentAverageMarkByGroupId(TWENTY_FOUR_GROUP_ID, ACTING_SUBJECT_ID));

        System.out.println("Average mark in Design at Design faculty is " + getStudentAverageMarkByFacultyId(DESIGN_FACULTY_ID, DESIGN_SUBJECT_ID));

        System.out.println("Average mark in Economic is " + getSubjectAverageMarkByUniversityId(bsaa.getId(), ECONOMIC_SUBJECT_ID));
    }

    private static double getStudentAverageMark(int studentId) throws RepositoryException {
        Mark[] marks = studentService.getById(studentId).getMarks();
        return getAverageMark(marks);
    }

    private static double getStudentAverageMarkByGroupId(int groupId, int subjectId) throws StudentsNotFoundException {
        Student[] students = studentService.getByGroupId(groupId);
        List<Mark> markList = new ArrayList<>();
        for (Student student : students) {
            List<Mark> marks = new ArrayList<>();
            if (student.getGroupId() == groupId) {
                marks.addAll(Arrays.asList(student.getMarks()));
            }
            for (Mark mark : marks) {
                if (mark.getSubjectId() == subjectId) {
                    markList.add(mark);
                }
            }
        }
        return getAverageMark(markList.toArray(new Mark[0]));
    }

    private static double getStudentAverageMarkByFacultyId(int facultyId, int subjectId) throws GroupsNotFoundException,
            StudentsNotFoundException {
        Group[] groups = groupService.getByFacultyId(facultyId);
        List<Integer> groupIds = new ArrayList<>();
        for (Group group : groups) {
            groupIds.add(group.getId());
        }

        Student[] students = studentService.getByGroupIds(groupIds.toArray(new Integer[0]));
        List<Mark> markList = new ArrayList<>();
        for (Student student : students) {
            List<Mark> marks = new ArrayList<>(Arrays.asList(student.getMarks()));
            for (Mark mark : marks) {
                if (mark.getSubjectId() == subjectId) {
                    markList.add(mark);
                }
            }
        }

        return getAverageMark(markList.toArray(new Mark[0]));
    }

    private static double getSubjectAverageMarkByUniversityId(int universityId, int subjectId) throws RepositoryException {
        University university = universityService.getById(universityId);

        List<Mark> markList = new ArrayList<>();
        int[] studentIds = university.getStudentIds();
        for (int id : studentIds) {
            markList.addAll(Arrays.asList(studentService.getById(id).getMarks()));
        }

        for (int i = 0; i < markList.size(); i++) {
            if (markList.get(i).getSubjectId() != subjectId) {
                markList.remove(i);
            }
        }

        return getAverageMark(markList.toArray(new Mark[0]));
    }

    private static double getAverageMark(Mark[] marks) {
        double average = 0;
        for (Mark mark : marks) {
            average += mark.getGrade();
        }
        average /= marks.length;
        return average;
    }

    private static void initSubjects() {
        subjectService.add(new Subject("Painting"));
        subjectService.add(new Subject("Acting"));
        subjectService.add(new Subject("Economic"));
        subjectService.add(new Subject("Decorative art"));
        subjectService.add(new Subject("Design"));
        subjectService.add(new Subject("Sculpture"));
        subjectService.add(new Subject("Psychology"));
    }

    private static University initBsaaUniversity() throws SubjectsNotFoundException, FacultiesNotFoundException,
            ImpossibleGradeException, RepositoryException {
        University bsaa = universityService.add(
                new University("Belarusian State Academy of Arts", "Art, science and culture.", initBsaaFaculties()));
        bsaa.addGroups(initBsaaGroups());
        bsaa.addStudents(initBsaaStudents());
        return bsaa;
    }

    private static Integer[] initBsaaFaculties() throws SubjectsNotFoundException {
        Integer[] theatreSubjectId = {
                subjectService.getByName("Acting").getId(),
                subjectService.getByName("Economic").getId(),
                subjectService.getByName("Psychology").getId()
        };

        Integer[] designSubjectId = {
                subjectService.getByName("Painting").getId(),
                subjectService.getByName("Economic").getId(),
                subjectService.getByName("Decorative art").getId(),
                subjectService.getByName("Design").getId()
        };

        return new Integer[]{
                facultyService.add(new Faculty("Theatre", theatreSubjectId)).getId(),
                facultyService.add(new Faculty("Design", designSubjectId)).getId()
        };
    }

    private static Integer[] initBsaaGroups() throws FacultiesNotFoundException {
        return new Integer[]{
                groupService.add(new Group("24", facultyService.getByName("Theatre").getId())).getId(),
                groupService.add(new Group("26", facultyService.getByName("Theatre").getId())).getId(),
                groupService.add(new Group("42", facultyService.getByName("Design").getId())).getId(),
                groupService.add(new Group("45", facultyService.getByName("Design").getId())).getId(),
        };
    }

    private static Integer[] initBsaaStudents() throws ImpossibleGradeException, RepositoryException, SubjectsNotFoundException {
        List<Integer> studentIdList = new ArrayList<>();

        Student hohlova = new Student("Hohlova", "Alina");
        hohlova.setGroupId(0);
        List<Mark> marksHohlova = new ArrayList<>();
        marksHohlova.add(new Mark(8, 1));
        marksHohlova.add(new Mark(9, 2));
        marksHohlova.add(new Mark(7, 6));
        hohlova.setMarkList(marksHohlova);
        studentIdList.add(studentService.add(hohlova).getId());

        Student rogova = new Student("Rogova", "Irina");
        rogova.setGroupId(0);
        List<Mark> marksRogova = new ArrayList<>();
        marksRogova.add(new Mark(6, 1));
        marksRogova.add(new Mark(10, 2));
        rogova.setMarkList(marksRogova);
        studentIdList.add(studentService.add(rogova).getId());

        Student orlov = new Student("Orlov", "Denis");
        orlov.setGroupId(1);
        List<Mark> marksOrlov = new ArrayList<>();
        marksOrlov.add(new Mark(5, 1));
        orlov.setMarkList(marksOrlov);
        studentIdList.add(studentService.add(orlov).getId());

        Student zolotova = new Student("Zolotova", "Arina");
        zolotova.setGroupId(1);
        List<Mark> marksZolotova = new ArrayList<>();
        marksZolotova.add(new Mark(8, 1));
        marksZolotova.add(new Mark(10, 6));
        zolotova.setMarkList(marksZolotova);
        studentIdList.add(studentService.add(zolotova).getId());

        Student repin = new Student("Repin", "Igor");
        repin.setGroupId(2);
        List<Mark> marksRepin = new ArrayList<>();
        marksRepin.add(new Mark(7, 0));
        marksRepin.add(new Mark(9, 2));
        marksRepin.add(new Mark(5, 4));
        repin.setMarkList(marksRepin);
        studentIdList.add(studentService.add(repin).getId());

        Student korobov = new Student("Korobov", "Pavel");
        korobov.setGroupId(2);
        List<Mark> marksKorobov = new ArrayList<>();
        marksKorobov.add(new Mark(6, 2));
        marksKorobov.add(new Mark(8, 3));
        korobov.setMarkList(marksKorobov);
        studentIdList.add(studentService.add(korobov).getId());

        Student saharov = new Student("Saharov", "Anton");
        saharov.setGroupId(3);
        List<Mark> marksSaharov = new ArrayList<>();
        marksSaharov.add(new Mark(4, 2));
        marksSaharov.add(new Mark(3, 4));
        saharov.setMarkList(marksSaharov);
        studentIdList.add(studentService.add(saharov).getId());

        Student babina = new Student("Babina", "Margarita");
        babina.setGroupId(3);
        List<Mark> marksBabina = new ArrayList<>();
        marksBabina.add(new Mark(10, 0));
        marksBabina.add(new Mark(6, 3));
        marksBabina.add(new Mark(7, 4));
        babina.setMarkList(marksBabina);
        studentIdList.add(studentService.add(babina).getId());

        return studentIdList.toArray(new Integer[0]);
    }
}
