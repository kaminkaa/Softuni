import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    protected Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return super.getAnimalType() + "[" + super.getAnimalName() + ", " + df.format(super.getAnimalWeight())
                + ", " + this.livingRegion + ", " + super.getFoodEaten() + "]";
    }
}
