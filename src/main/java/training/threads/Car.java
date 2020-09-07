package training.threads;

import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private int number;
    private Parking parking;
    private final long PARKING_WAITING_TIME = TimeUnit.SECONDS.toSeconds(5);
    private final long PARKING_TIME = TimeUnit.SECONDS.toSeconds(2);
    private long startTime;

    public Car(int carId, Parking parking) {
        this.number = carId;
        this.parking = parking;
    }

    public void run() {
        boolean isParked;

        System.out.printf("Car %d started \n", number);
        startTime = System.currentTimeMillis();
        do {
            isParked = parking.park(number);
        } while (!isParked && hasFreeTime());

        if (isParked) {
            try {
                sleep(PARKING_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            parking.leave(number);
        } else {
            System.out.printf("Car %d left for another parking \n", number);
        }
    }

    public boolean hasFreeTime() {
        long actualTime = System.currentTimeMillis();
        long currentWaitingTime = actualTime - startTime;
        return currentWaitingTime < PARKING_WAITING_TIME;
    }
}
