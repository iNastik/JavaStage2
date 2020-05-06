package training.errorandexeptions;

import training.errorandexeptions.entity.Faculty;
import training.errorandexeptions.entity.University;

public class Main {
    public static void main(String [] args) {
        University university = new University(
                new Faculty("Theatre"),
                new Faculty("Art"),
                new Faculty("Screen Arts"),
                new Faculty("Design"));

        for (Faculty faculty : university.getFaculties()) {
            System.out.println(faculty);
        }
    }
}
