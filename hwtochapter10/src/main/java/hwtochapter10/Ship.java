package hwtochapter10;

public class Ship extends Vehicle {
    private int tonnage;

    public Ship(String make, String model, int year, int tonnage) {
        super(make, model, year);
        this.tonnage = tonnage;
    }

    public void move() {
        System.out.println("The ship sails across the seas.");
    }
}
