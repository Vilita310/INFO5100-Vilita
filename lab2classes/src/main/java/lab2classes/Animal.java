package lab2classes;

public abstract class Animal {
    protected String typicalSize;
    protected double typicalWeight;
    protected boolean isPredator;
    protected String diet; // Vegetarian, Omnivore, Carnivore

    public Animal(String size, double weight, boolean predator, String diet) {
        this.typicalSize = size;
        this.typicalWeight = weight;
        this.isPredator = predator;
        this.diet = diet;
    }

    // Abstract method to be implemented by subclasses
    public abstract void move();
}
