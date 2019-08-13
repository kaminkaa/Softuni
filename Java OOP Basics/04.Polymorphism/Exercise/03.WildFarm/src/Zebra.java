public class Zebra extends Mammal {
    protected Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.setFoodEaten(super.getFoodEaten() + food.quantity);
        } else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
