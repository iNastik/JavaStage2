package training.threads;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Integer> storage;
    private static final int CAPACITY = 3;

    public Parking() {
        storage = new ArrayList<>();
    }

    public synchronized boolean park(int carId) {
        if (storage.size() < CAPACITY) {
            storage.add(carId);
            System.out.printf("Car %d parked successfully \n", carId);
        } else {
            return false;
        }
        return true;
    }

    public synchronized void leave(int carNumber) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i) == carNumber) {
                storage.remove(storage.get(i));
                System.out.printf("Car %d left the parking \n", carNumber);
            }
        }
    }
}
