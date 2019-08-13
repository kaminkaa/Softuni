import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _06_Animals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        while (!inputLine.equals("Beast!")) {
            String[] tokens = reader.readLine().split(" ");
            try {
                Animal animal = getAnimal(inputLine, tokens);
                System.out.println(animal);
                System.out.println(animal.produceSound());
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            inputLine = reader.readLine();
        }
    }

    private static Animal getAnimal(String type, String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String gender = tokens.length == 3 ? tokens[2] : null;
        switch (type) {
            case "Cat":
                return new Cat(name, age, gender);
            case "Dog":
                return new Dog(name, age, gender);
            case "Frog":
                return new Frog(name, age, gender);
            case "Kitten":
                return new Kitten(name, age);
            case "Tomcat":
                return new Tomcat(name, age);
            default:
                throw new IllegalArgumentException("Invalid input!");
        }
    }

    static abstract public class Animal {
        protected String name;
        protected int age;
        protected String gender;

        public Animal(String name, int age, String gender) {
            this.setName(name);
            this.setAge(age);
            this.setGender(gender);
        }

        public String getName() {
            return this.name;
        }

        private void setName(String name) {
            if (name.equals("\\\\s+")) {
                throw new IllegalArgumentException("Invalid input!");
            }
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        private void setAge(int age) {
            if (age < 1) {
                throw new IllegalArgumentException("Invalid input!");
            }
            this.age = age;
        }

        public String getGender() {
            return this.gender;
        }

        private void setGender(String gender) {
            if (gender.equals("\\\\s+") || (!gender.equals("Male") && !gender.equals("Female"))) {
                throw new IllegalArgumentException("Invalid input!");
            }
            this.gender = gender;
        }

        public abstract String produceSound();

        @Override
        public String toString() {
            return String.format("%s\n%s %d %s", getClass().getSimpleName(),
                    this.name, this.age, this.gender);
        }
    }

    static public class Dog extends Animal {

        public Dog(String name, int age, String gender) {
            super(name, age, gender);
        }

        public String produceSound() {
            return "BauBau";
        }
    }

    static public class Frog extends Animal {

        public Frog(String name, int age, String gender) {
            super(name, age, gender);
        }

        public String produceSound() {
            return "Frogggg";
        }
    }

    static public class Cat extends Animal {

        public Cat(String name, int age, String gender) {
            super(name, age, gender);
        }

        public String produceSound() {
            return "MiauMiau";
        }
    }

    static public class Kitten extends Cat {

        public Kitten(String name, int age) {
            super(name, age, "female");
        }

        public String produceSound() {
            return "Miau";
        }
    }

    static public class Tomcat extends Cat {

        public Tomcat(String name, int age) {
            super(name, age, "male");
        }

        public String produceSound() {
            return "Give me one million b***h";
        }
    }
}
