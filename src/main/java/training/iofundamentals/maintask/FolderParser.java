package training.iofundamentals.maintask;

import java.io.File;

public class FolderParser {
    private static final String FOLDER_LEVEL = "    |";
    private static final String FOLDER_DELIMITER = "     ";
    private static final String POINTER = "----";
    private static final String ELEMENT_POINTER = "    Ⱶ";
    private static final String LAST_ELEMENT_POINTER = "    L";


    public void parseFolderStructure(File file) {
        printStructure(file, 1, 0);
    }

    private void printStructure(File file, int fileLevel, int stickLevel) {
        File[] files = file.listFiles();
        int filesLength = files.length;
        for (int i = 0; i < filesLength; i++) {
            File currentFile = files[i];

            for (int j = 0; j < stickLevel; j++) {
                System.out.print(FOLDER_DELIMITER);
            }

            int editedFolderLevel = fileLevel - stickLevel;
            for (int j = 0; j < editedFolderLevel; j++) {
                if (j == editedFolderLevel - 1) {
                    if (i == filesLength - 1) {
                        System.out.print(LAST_ELEMENT_POINTER);
                    } else {
                        System.out.print(ELEMENT_POINTER);
                    }
                } else {
                    System.out.print(FOLDER_LEVEL);
                }
            }

            if (currentFile.isDirectory()) {
                if (i == filesLength - 1) {
                    stickLevel++;
                }
                System.out.println(POINTER + currentFile.getName());
                printStructure(currentFile, fileLevel + 1, stickLevel);
            }

            if (currentFile.isFile()) {
                System.out.println(POINTER + currentFile.getName());
            }
        }
    }
}
