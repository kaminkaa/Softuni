import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _04_ShoppingSpree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        Map<String,Person> people = new LinkedHashMap<>();
        Map<String,Product> products = new HashMap<>();

        try {
            addPeople(people, reader);
            addProducts(products, reader);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        line = reader.readLine().split(" ");
        while (!line[0].equals("END")) {
            String person = line[0];
            String product = line[1];

            try {
                people.get(person).addProduct(products.get(product));
                System.out.println(person + " bought " + product);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            line = reader.readLine().split("\\s+");
        }

        for (Map.Entry<String, Person> entry : people.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void addPeople (Map<String,Person> people, BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(";");
        for (int i = 0; i < line.length; i++) {
            String[] tokens = line[i].split("=");
            String personName = tokens[0];
            int money = Integer.parseInt(tokens[1]);

            people.put(personName, new Person(personName, money));
        }
    }

    public static void addProducts (Map<String,Product> products, BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(";");
        for (int i = 0; i < line.length; i++) {
            String[] tokens = line[i].split("=");
            String productName = tokens[0];
            int cost = Integer.parseInt(tokens[1]);

            products.put(productName, new Product(productName, cost));
        }
    }

    static class Person {
        private String name;
        private int money;
        private List<Product> products;

        public Person(String name, int money) {
            this.setName(name);
            this.setMoney(money);
            this.products = new ArrayList<>();
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            if (name.equals("") || name.equals(" ")) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
        }

        public int getMoney() {
            return this.money;
        }

        public void setMoney(int money) {
            if (money < 0) {
                throw new IllegalArgumentException("Money cannot be negative");
            }
            this.money = money;
        }

        public List<Product> getProducts() {
            return this.products;
        }

        public void addProduct(Product product) {
            if (product.getCost() > this.getMoney()) {
                throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
            }

            this.products.add(product);
            this.money -= product.getCost();
        }

        @Override
        public String toString() {
            if (this.products.isEmpty()) {
                return this.getName() + " - Nothing bought";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.getName()).append(" - ");
            sb.append(
                    this.getProducts().stream()
                        .map(Product::getName)
                            .collect(Collectors.joining(", "))
            );
            return sb.toString();
        }
    }

    static class Product {
        private String name;
        private int cost;

        public Product(String name, int cost) {
            this.setName(name);
            this.setCost(cost);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            if (name.equals("") || name.equals(" ")) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
        }

        public int getCost() {
            return this.cost;
        }

        public void setCost(int cost) {
            if (cost < 0) {
                throw new IllegalArgumentException("Money cannot be negative");
            }
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }
}
