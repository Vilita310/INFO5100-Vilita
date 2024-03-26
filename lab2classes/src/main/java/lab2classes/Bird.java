package lab2classes;

public class Bird extends Animal {
    private double wingspan;
    private String species;

    public Bird(String size, double weight, boolean predator, String diet, double wingspan, String species) {
        super(size, weight, predator, diet);
        this.wingspan = wingspan;
        this.species = species;
    }

    public void move() {
        System.out.println("This bird flies with a wingspan of " + wingspan + " meters.");
    }
}
