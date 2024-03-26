package lab2classes;

public class AnimalProgram {
    public static void main(String[] args) {
        Animal eagle = new Bird("Medium", 6.5, true, "Carnivore", 2.1, "Eagle");
        Animal lion = new LandAnimal("Large", 190.0, true, "Carnivore", 4, "Lion");
        Animal salmon = new Fish("Medium", 1.4, false, "Omnivore", 6, "Salmon");

        eagle.move();
        lion.move();
        salmon.move();
    }
}