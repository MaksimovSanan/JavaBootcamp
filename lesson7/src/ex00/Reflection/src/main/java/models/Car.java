package models;

public class Car {
    private String model;
    private Integer speed;

    public Car() {
        model = "Niva";
        speed = 70;
    }

    public Car(String model, Integer speed) {
        this.model = model;
        this.speed = speed;
    }

    void upgrade(int changeSpeed) {
        speed += changeSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
