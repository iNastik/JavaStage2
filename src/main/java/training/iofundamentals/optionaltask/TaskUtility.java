package training.iofundamentals.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskUtility {
    public String createNewDirectory(String directoryPathname) {
        File directory = new File(directoryPathname);
        if (!directory.exists()) {
            directory.mkdir();
        }
        return directoryPathname;
    }

    public File createNewFile(String filePathname) {
        File file = new File(filePathname);
        try {
            file.createNewFile();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public List<String> readFile(String filePathname) throws IOException {
        List<String> fileStrings = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(filePathname);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                fileStrings.add(currentLine);
            }
        }
        return fileStrings;
    }
}
