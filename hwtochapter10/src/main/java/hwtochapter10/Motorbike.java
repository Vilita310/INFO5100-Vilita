package hwtochapter10;

public class Motorbike extends Vehicle {
    public Motorbike(String make, String model, int year) {
        super(make, model, year);
    }

    public void move() {
        System.out.println("The motorbike races on two wheels.");
    }
}
