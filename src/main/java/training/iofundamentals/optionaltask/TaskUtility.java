package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskUtility {

    public List<String> readFile(String filePathname) throws IOException {
        List<String> fileStrings = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(filePathname);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.ready()) {
                fileStrings.add(bufferedReader.readLine());
            }
        }
        return fileStrings;
    }

    public File createDirectoryAndFile(String directoryPathname, String fileName) {
        File directory = new File(directoryPathname);
        directory.mkdir();
        File file = new File(directoryPathname + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
