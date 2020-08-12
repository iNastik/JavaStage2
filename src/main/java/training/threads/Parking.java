package training.threads;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Parking {
    @Getter
    @Setter
    private int parkingCapacity;
    @Getter
    @Setter
    private int carsCounter = 0;
    private List<Car> carList;

    public Parking(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
        carList = new ArrayList<>();
    }

    public Car[] getCars() {
        return carList.toArray(new Car[0]);
    }

    public synchronized void addCar(Car car) {
        try {
            if (parkingCapacity > carsCounter) {
                carList.add(car);
                System.out.println("car " + car.getNumber() + " arrived");
                carsCounter++;
            } else {
                System.out.println("there is no free place");
                wait(TimeUnit.MINUTES.toMinutes(2));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
