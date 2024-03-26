package hwtochapter10;

public class Car extends Vehicle {
    private int doors;

    public Car(String make, String model, int year, int doors) {
        super(make, model, year);
        this.doors = doors;
    }

    public void move() {
        System.out.println("The car drives on roads.");
    }
}
