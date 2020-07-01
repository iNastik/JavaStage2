package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task10 {
    public static void main(String[] args) throws IOException {
        TaskUtility taskUtility = new TaskUtility();
        List<String> fileStrings = taskUtility.readFile("F:\\OptionalTask\\OriginalFileTask10.txt");
        Task10 task10 = new Task10();

        String directoryPathName = "F:\\ResultFolder";
        String fileName = "Task10.txt";
        File outputFile = taskUtility.createDirectoryAndFile(directoryPathName, fileName);
        task10.swapFirstAndLastWordsInEachLine(fileStrings, outputFile);
    }

    public void swapFirstAndLastWordsInEachLine(List<String> fileStrings, File outputFile) throws IOException {
        List<String> reorderedStrings = new ArrayList<>();

        for (String string : fileStrings) {
            String[] strings = string.split(" ");
            String firstWord = strings[0];
            strings[0] = strings[strings.length - 1];
            strings[strings.length - 1] = firstWord;
            for (String s : strings) {
                reorderedStrings.add(s + " ");
            }
            reorderedStrings.add("\n");
        }

        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            for (String string : reorderedStrings) {
                bufferedWriter.write(string);
            }
        }
    }
}
