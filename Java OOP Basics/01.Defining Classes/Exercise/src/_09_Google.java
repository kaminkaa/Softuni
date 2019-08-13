import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _09_Google {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line;

        HashMap<String, Person> people = new HashMap<>();

        line = reader.readLine().split("\\s+");

        while (!line[0].equals("End")) {
            people.putIfAbsent(line[0], new Person(line[0]));
            Person currentPerson = people.get(line[0]);

            switch (line[1]) {
                case "company":
                    currentPerson.company = new Company(line[2], line[3], Double.parseDouble(line[4]));
                    break;

                case "pokemon":
                    Pokemon pokemon = new Pokemon(line[2], line[3]);
                    currentPerson.pokemons.add(pokemon);
                    break;

                case "parents":
                    Parent parent = new Parent(line[2], line[3]);
                    currentPerson.parents.add(parent);
                    break;

                case "children":
                    Child child = new Child(line[2], line[3]);
                    currentPerson.children.add(child);
                    break;

                case "car":
                    currentPerson.car = new Car(line[2], line[3]);
                    break;
            }

            line = reader.readLine().split("\\s+");
        }

        String personName = reader.readLine();
        Person person = people.get(personName);

        System.out.println(person);
    }

    static class Person {
        public String name;
        public List<Parent> parents;
        public List<Child> children;
        public List<Pokemon> pokemons;
        public Company company;
        public Car car;

        public Person (String name) {
            this.name = name;
            this.parents = new ArrayList<>();
            this.children = new ArrayList<>();
            this.pokemons = new ArrayList<>();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(this.name).append("\n");
            sb.append("Company:").append("\n");
            if (this.company != null) sb.append(this.company).append("\n");
            sb.append("Car:").append("\n");
            if (this.car != null) sb.append(this.car).append("\n");
            sb.append("Pokemon:").append("\n");
            if (this.pokemons != null) this.pokemons.forEach(pokemon -> sb.append(pokemon).append("\n"));
            sb.append("Parents:").append("\n");
            if (this.parents != null) this.parents.forEach(parent -> sb.append(parent).append("\n"));
            sb.append("Children:").append("\n");
            if (this.children != null) this.children.forEach(child -> sb.append(child).append("\n"));

            return sb.toString();
        }
    }

    static class Parent {
        public String name;
        public String birthday;

        public Parent(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }

    static class Child {
        public String name;
        public String birthday;

        public Child(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }

    static class Pokemon {
        public String name;
        public String type;

        public Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.name, this.type);
        }
    }

    static class Company {
        public String name;
        public String department;
        public double salary;

        public Company(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s %s %.2f", this.name, this.department, this.salary);
        }
    }

    static class Car {
        public String model;
        public String speed;

        public Car(String model, String speed) {
            this.model = model;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return String.format("%s %s", this.model, this.speed);
        }
    }
}
