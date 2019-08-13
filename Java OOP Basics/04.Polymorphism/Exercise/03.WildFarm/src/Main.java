import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = reader.readLine().split(" ");

        boolean even = true;
        List<Animal> animals = new ArrayList<>();

        while (!inputLine[0].equals("End")) {

            if (even) {
                String animalType = inputLine[0];
                String animalName = inputLine[1];
                double animalWeight = Double.parseDouble(inputLine[2]);
                String livingRegion = inputLine[3];

                switch (animalType) {
                    case "Mouse":
                        animals.add(new Mouse(animalName, animalType, animalWeight, livingRegion));
                        break;
                    case "Zebra":
                        animals.add(new Zebra(animalName, animalType, animalWeight, livingRegion));
                        break;
                    case "Cat":
                        String breed = inputLine[4];
                        animals.add(new Cat(animalName, animalType, animalWeight, livingRegion, breed));
                        break;
                    case "Tiger":
                        animals.add(new Tiger(animalName, animalType, animalWeight, livingRegion));
                        break;
                }
            } else {
                Food food = null;

                String foodType = inputLine[0];
                int qty = Integer.parseInt(inputLine[1]);

                if (foodType.equals("Vegetable")) {
                    food = new Vegetable(qty);
                } else {
                    food = new Meat(qty);
                }

                Animal currentAnimal = animals.get(animals.size()-1);

                currentAnimal.makeSound();

                try {
                    currentAnimal.eat(food);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            even = !even;
            inputLine = reader.readLine().split(" ");
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
