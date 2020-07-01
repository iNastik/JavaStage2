package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) throws IOException {
        TaskUtility taskUtility = new TaskUtility();
        List<String> fileStrings = taskUtility.readFile("F:\\OptionalTask\\OriginalFileTask5.txt");
        Task5 task5 = new Task5();

        String directoryPathName = "F:\\ResultFolder";
        String fileName = "Task5.txt";
        File outputFile = taskUtility.createDirectoryAndFile(directoryPathName, fileName);
        task5.capitalizeNameByAverageMark(fileStrings, outputFile);
    }

    public void capitalizeNameByAverageMark(List<String> fileStrings, File outputFile) throws IOException {
        List<String> studentDataList = new ArrayList<>();
        int averageMarkForComparison = 7;
        for (String s : fileStrings) {
            String[] strings = s.split(" ");
            double averageMark;
            int markSum = 0;
            int markCount = 0;
            for (int i = 1; i < strings.length; i++) {
                int mark = Integer.parseInt(strings[i]);
                markSum += mark;
                markCount++;
                averageMark = (double) markSum / markCount;
                if (averageMark > averageMarkForComparison) {
                    strings[0] = strings[0].toUpperCase();
                }
            }

            for (String str : strings) {
                studentDataList.add(str + " ");
            }
        }

        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            for (String s : studentDataList) {
                String STUDENT_NAME_REGEX = "\\D+";
                if (!s.equals(studentDataList.get(0)) && s.matches(STUDENT_NAME_REGEX)) {
                    bufferedWriter.write("\n");
                }
                bufferedWriter.write(s);
            }
        }
    }
}
