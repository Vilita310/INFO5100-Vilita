package lab2classes;

public class Fish extends Animal {
    private int numberOfFins;
    private String species;

    public Fish(String size, double weight, boolean predator, String diet, int fins, String species) {
        super(size, weight, predator, diet);
        this.numberOfFins = fins;
        this.species = species;
    }

    public void move() {
        System.out.println("This fish swims with its " + numberOfFins + " fins.");
    }
}
