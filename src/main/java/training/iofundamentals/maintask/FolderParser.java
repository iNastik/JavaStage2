package training.iofundamentals.maintask;

import java.io.*;

public class FolderParser {
    private static final String FOLDER_LEVEL = "    |";
    private static final String FOLDER_DELIMITER = "     ";
    private static final String POINTER = "----";
    private static final String ELEMENT_POINTER = "    Ⱶ";
    private static final String LAST_ELEMENT_POINTER = "    L";
    private static final String REGEX = "(\\\\[^\\\\]*)$";
    private static final String OUTPUT_FILE_NAME = "\\files_three.txt";

    public void parseFolderStructure(File file) throws IOException {
        File outputFile = new File(file.getPath().replaceAll(REGEX, "") + OUTPUT_FILE_NAME);
        try (OutputStream outputStream = new FileOutputStream(outputFile);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
             BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {

            bufferedWriter.write(file.getName() + "\n");
            printStructure(bufferedWriter, file, 1, 0);
        }
    }

    private void printStructure(BufferedWriter bufferedWriter, File file, int fileLevel, int stickLevel) throws IOException {
        File[] files = file.listFiles();

        if (files.length == 0) {
            throw new FileNotFoundException("no files found on this path");
        }

        int filesLength = files.length;
        for (int i = 0; i < filesLength; i++) {
            File currentFile = files[i];

            for (int j = 0; j < stickLevel; j++) {
                bufferedWriter.write(FOLDER_DELIMITER);
            }

            int editedFolderLevel = fileLevel - stickLevel;
            for (int j = 0; j < editedFolderLevel; j++) {
                if (j == editedFolderLevel - 1) {
                    if (i == filesLength - 1) {
                        bufferedWriter.write(LAST_ELEMENT_POINTER);
                    } else {
                        bufferedWriter.write(ELEMENT_POINTER);
                    }
                } else {
                    bufferedWriter.write(FOLDER_LEVEL);
                }
            }

            if (currentFile.isDirectory()) {
                if (i == filesLength - 1) {
                    stickLevel++;
                }
                bufferedWriter.write(POINTER + currentFile.getName() + "\n");
                printStructure(bufferedWriter, currentFile, fileLevel + 1, stickLevel);
            }

            if (currentFile.isFile()) {
                bufferedWriter.write(POINTER + currentFile.getName() + "\n");
            }
        }
    }
}

