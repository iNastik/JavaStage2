package training.iofundamentals.maintask;

import org.apache.commons.math3.util.Precision;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {
    private static final String FOLDER_POINTER = "  |----";
    private static final String FILE_POINTER = "      ";
    private static final String FILE_NAME_REGEX = "(^[ |]*)(\\w+)([.]\\w+$)";
    private List<String> fileStrings = new ArrayList<>();

    public void readFile(File file) throws IOException {
        try (InputStream inputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            while (bufferedReader.ready()) {
                fileStrings.add(bufferedReader.readLine());
            }

            countFolders(fileStrings);
            countFiles(fileStrings);
            countAverageFilesNumberInFolder(fileStrings);
            countAverageFileNameLength(fileStrings);
        }
    }

    public void countFolders(List<String> fileStrings) {
        int foldersNumber = 0;
        for (String s : fileStrings) {
            if (s.startsWith(FOLDER_POINTER)) {
                foldersNumber++;
            }
        }
        System.out.println("Number of folders is " + foldersNumber);
    }

    public void countFiles(List<String> fileStrings) {
        int filesNumber = 0;
        for (String s : fileStrings) {
            if (s.contains(FILE_POINTER)) {
                filesNumber++;
            }
        }
        System.out.println("Number of files is " + filesNumber);
    }

    public void countAverageFilesNumberInFolder(List<String> fileStrings) {
        double averageFilesNumber = 0;
        int foldersNumber = 0;
        int filesNumber = 0;
        for (int i = 0; i < fileStrings.size(); i++) {
            String currentString = fileStrings.get(i);
            if (currentString.startsWith(FOLDER_POINTER)) {
                if (filesNumber != 0) {
                    averageFilesNumber = (averageFilesNumber + filesNumber) / foldersNumber;
                    filesNumber = 0;
                }
                foldersNumber++;
            }

            if (currentString.contains(FILE_POINTER)) {
                filesNumber++;
            }

            if (i == fileStrings.size() - 1) {
                averageFilesNumber = (averageFilesNumber + filesNumber) / foldersNumber;
            }
        }
        System.out.println("Average files number in folder is " + averageFilesNumber);
    }

    public void countAverageFileNameLength(List<String> fileStrings) {
        double averageFileNameLength;
        int filesCount = 0;
        int totalFileNameLength = 0;
        for (String s : fileStrings) {

            if (s.contains(FILE_POINTER)) {
                Pattern pattern = Pattern.compile(FILE_NAME_REGEX);
                Matcher matcher = pattern.matcher(s);

                if (matcher.find()) {
                    String fileName = matcher.group(2);
                    totalFileNameLength += fileName.length();
                    filesCount++;
                }
            }
        }
        averageFileNameLength = (double) totalFileNameLength / filesCount;
        System.out.println("Average length of the file name is " + Precision.round(averageFileNameLength, 2));
    }
}
