import java.text.DecimalFormat;

public class Cat extends Feline {
    private String breed;

    protected Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return this.breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(super.getFoodEaten() + food.quantity);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return super.getAnimalType() + "[" + super.getAnimalName() + ", " + this.breed + ", " + df.format(super.getAnimalWeight())
                + ", " + this.livingRegion + ", " + super.getFoodEaten() + "]";
    }
}
