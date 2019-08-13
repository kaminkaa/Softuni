import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _05_PizzaCalories {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        line = reader.readLine().split(" ");
        Pizza pizza;
        try {
            pizza = new Pizza(line[1], Integer.parseInt(line[2]));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        line = reader.readLine().split(" ");
        Dough dough;
        try {
            dough = new Dough(line[1], line[2], Integer.parseInt(line[3]));
            pizza.setDough(dough);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        line = reader.readLine().split(" ");
        while (!line[0].equals("END")) {
            Topping topping;
            try {
                topping = new Topping(line[1], Integer.parseInt(line[2]));
                pizza.addTopping(topping);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }

            line = reader.readLine().split(" ");
        }

        System.out.println(String.format("%s - %.2f", pizza.getName(), pizza.getCalories()));
    }

    static class Pizza {
        private String name;
        private Dough dough;
        private List<Topping> toppings;
        private double calories;

        public Pizza(String name, int numberOfToppings) {
            this.setName(name);
            if (numberOfToppings < 0 || numberOfToppings > 10) {
                throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
            }
            this.toppings = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name.length() < 1 || name.length() > 15) {
                throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
            }
            this.name = name;
        }


        public void setDough(Dough dough) {
            this.dough = dough;
        }

        public void addTopping(Topping topping) {
            this.toppings.add(topping);
        }

        public double getCalories() {
            this.calories = this.dough.getCalories();
            this.toppings.forEach(topping -> this.calories += topping.getCalories());
            return this.calories;
        }
    }

    static class Dough {
        private String flourType;
        private Map<String, Double> flourTypes = new HashMap<String, Double>() {{
            put("White", 1.5);
            put("Wholegrain", 1.0);
        }};
        private String bakingTechnique;
        private Map<String, Double> bakingTechniques = new HashMap<String, Double>() {{
           put("Crispy", 0.9);
           put("Chewy", 1.1);
           put("Homemade", 1.0);
        }};
        private int weight;

        public Dough(String flourType, String bakingTechnique, int weight) {
            this.setFlourType(flourType);
            this.setBakingTechnique(bakingTechnique);
            this.setWeight(weight);
        }

        public double getCalories() {
            return  2 * this.weight * this.flourTypes.get(this.flourType) * this.bakingTechniques.get(this.bakingTechnique);
        }

        public String getFlourType() {
            return this.flourType;
        }

        public void setFlourType(String flourType) {
            if (!this.flourTypes.containsKey(flourType)) {
                throw new IllegalArgumentException("Invalid type of dough.");
            }
            this.flourType = flourType;
        }

        public String getBakingTechnique() {
            return this.bakingTechnique;
        }

        public void setBakingTechnique(String bakingTechnique) {
            if (!this.bakingTechniques.containsKey(bakingTechnique)) {
                throw new IllegalArgumentException("Invalid type of dough.");
            }
            this.bakingTechnique = bakingTechnique;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            if (weight <= 0 || weight > 200) {
                throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
            }
            this.weight = weight;
        }
    }

    static class Topping {
        private String name;
        private int weight;
        private Map<String, Double> toppingsAvailable = new HashMap<String, Double>() {{
            put("Meat", 1.2);
            put("Veggies", 0.8);
            put("Cheese", 1.1);
            put("Sauce", 0.9);
        }};

        public Topping(String name, int weight) {
            this.setName(name);
            this.setWeight(weight);
        }

        public double getCalories() {
            return  2 * this.weight * this.toppingsAvailable.get(this.name);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            if (!this.toppingsAvailable.containsKey(name)) {
                throw new IllegalArgumentException("Cannot place " + name + " on top of your pizza.");
            }
            this.name = name;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(int weight) {
            if (weight <= 0 || weight > 50) {
                throw new IllegalArgumentException(this.name + " weight should be in the range [1..50].");
            }
            this.weight = weight;
        }
    }
}
