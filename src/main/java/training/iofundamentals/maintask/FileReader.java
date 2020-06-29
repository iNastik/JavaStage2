package training.iofundamentals.maintask;

import java.io.File;
import java.io.IOException;

public class FileReader {
    public void readFile(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            FolderParser folderParser = new FolderParser();
            folderParser.parseFolderStructure(file);
        }

        if (file.isFile() && file.getName().contains(".txt")) {
            FileParser fileParser = new FileParser();
            fileParser.readFile(file);
        }
    }
}
