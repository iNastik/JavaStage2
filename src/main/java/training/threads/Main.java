package training.threads;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        for (int i = 1; i < 9; i++) {
            new Car(i, parking).start();
        }
    }
}
