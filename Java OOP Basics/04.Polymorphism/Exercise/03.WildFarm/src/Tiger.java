public class Tiger extends Feline {
    protected Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            super.setFoodEaten(super.getFoodEaten() + food.quantity);
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
