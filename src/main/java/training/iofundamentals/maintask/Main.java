package training.iofundamentals.maintask;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = args[0];

        FileReader fileReader = new FileReader();
        fileReader.readFile(path);
    }
}
