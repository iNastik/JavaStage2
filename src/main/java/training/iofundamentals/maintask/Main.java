package training.iofundamentals.maintask;

public class Main {
    public static void main(String[] args) {
        String path = args[0];
        System.out.println(path);

        FileReader fileReader = new FileReader();
        fileReader.readFile(path);
    }
}

