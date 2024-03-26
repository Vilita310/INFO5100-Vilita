package hwtochapter10;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car("Honda", "Civic", 2020, 4);
        Vehicle motorbike = new Motorbike("Harley-Davidson", "Street 750", 2021);
        Vehicle aircraft = new Aircraft("Boeing", "747", 2019, 35000);
        Vehicle ship = new Ship("Royal Caribbean", "Symphony of the Seas", 2018, 228081);

        car.move();
        motorbike.move();
        aircraft.move();
        ship.move();
    }
}
