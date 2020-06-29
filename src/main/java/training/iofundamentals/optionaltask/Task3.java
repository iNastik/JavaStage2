package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws IOException {
        TaskUtility taskUtility = new TaskUtility();
        List<String> fileStrings = taskUtility.readFile("F:\\OptionalTask\\OriginalFileTask3.txt");
        Task3 task3 = new Task3();

        String directoryPathName = taskUtility.createNewDirectory("F:\\NewFolder");
        File outputFile = taskUtility.createNewFile(directoryPathName + "\\Task3.txt");
        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
            task3.writeCharactersOfEachLineInReverseOrder(fileStrings,bufferedWriter);
        }
    }

    public void writeCharactersOfEachLineInReverseOrder(List<String> fileStrings, BufferedWriter bufferedWriter) throws IOException {
        for (String s : fileStrings) {
            StringBuffer output = new StringBuffer(s).reverse();
            bufferedWriter.write(output.toString());
            bufferedWriter.write("\n");
        }
    }
}
