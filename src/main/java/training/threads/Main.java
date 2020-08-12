package training.threads;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(3);

        for (int i = 0; i < 8; i++) {
            Car car = new Car(i);
            car.start();
            parking.addCar(car);
        }
    }
}
