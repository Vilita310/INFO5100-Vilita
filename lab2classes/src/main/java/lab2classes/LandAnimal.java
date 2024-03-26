package lab2classes;

public class LandAnimal extends Animal {
    private int numberOfLegs;
    private String species;

    public LandAnimal(String size, double weight, boolean predator, String diet, int legs, String species) {
        super(size, weight, predator, diet);
        this.numberOfLegs = legs;
        this.species = species;
    }

    public void move() {
        System.out.println("This land animal walks on its " + numberOfLegs + " legs.");
    }
}
