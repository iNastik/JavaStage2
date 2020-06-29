package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) throws IOException {
        TaskUtility taskUtility = new TaskUtility();
        List<String> fileStrings = taskUtility.readFile("F:\\OptionalTask\\OriginalFileTask5.txt");
        Task5 task5 = new Task5();

        String directoryPathName = taskUtility.createNewDirectory("F:\\NewFolder");
        File outputFile = taskUtility.createNewFile(directoryPathName + "\\Task5.txt");
        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            task5.capitalizeNameByAverageMark(fileStrings, bufferedWriter);
        }
    }

    public void capitalizeNameByAverageMark(List<String> fileStrings, BufferedWriter bufferedWriter) throws IOException {
        List<String> studentDataList = new ArrayList<>();
        for (String s : fileStrings) {
            String[] strings = s.split(" ");
            double averageMark = 0;
            int markSum = 0;
            int markCount = 0;
            for (int i = 1; i < strings.length; i++) {
                int mark = Integer.parseInt(strings[i]);
                markSum += mark;
                markCount++;
                averageMark = (double) markSum / markCount;
                if (averageMark > 7) {
                    strings[0] = strings[0].toUpperCase();
                }
            }
            for (String str : strings) {
                studentDataList.add(str + " ");
            }
        }

        for (String s : studentDataList) {
            if (!s.equals(studentDataList.get(0)) && s.matches("\\D+")) {
                bufferedWriter.write("\n");
            }
            bufferedWriter.write(s);
        }
    }
}

