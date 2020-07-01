package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws IOException {
        TaskUtility taskUtility = new TaskUtility();
        List<String> fileStrings = taskUtility.readFile("F:\\OptionalTask\\OriginalFileTask3.txt");
        Task3 task3 = new Task3();

        String directoryPathName = "F:\\ResultFolder";
        String fileName = "Task3.txt";
        File outputFile = taskUtility.createDirectoryAndFile(directoryPathName, fileName);
        task3.writeCharactersOfEachLineInReverseOrder(fileStrings, outputFile);
    }

    public void writeCharactersOfEachLineInReverseOrder(List<String> fileStrings, File outputFile) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            for (String s : fileStrings) {
                StringBuffer output = new StringBuffer(s).reverse();
                bufferedWriter.write(output.toString());
                bufferedWriter.write("\n");
            }
        }
    }
}
