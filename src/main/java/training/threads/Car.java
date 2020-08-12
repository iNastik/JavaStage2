package training.threads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car extends Thread{
    private int number;

    public Car(int number) {
        this.number = number;
    }

    public void run() {}
}
