package hwtochapter10;

public class Aircraft extends Vehicle {
    private int altitude;

    public Aircraft(String make, String model, int year, int altitude) {
        super(make, model, year);
        this.altitude = altitude;
    }

    public void move() {
        System.out.println("The aircraft soars in the sky.");
    }
}
