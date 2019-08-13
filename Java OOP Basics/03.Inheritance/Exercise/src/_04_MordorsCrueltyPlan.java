import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _04_MordorsCrueltyPlan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputFood = reader.readLine().split(" ");

        Gandalf gandalf = new Gandalf();
        gandalf.eat(inputFood);

        System.out.println(gandalf.getHappinessPoints());
        System.out.println(gandalf.getMood());
    }

    static public class Gandalf {
        private Map<String, Integer> food = new HashMap<String, Integer>(){{
            put("cram", 2);
            put("lembas", 3);
            put("apple", 1);
            put("melon", 1);
            put("honeycake", 5);
            put("mushrooms", -10);
        }};
        private int happinessPoints;

        public Gandalf() {
            this.happinessPoints = 0;
        }

        public void eat(String[] inputFood) {
            inputFood = Arrays.stream(inputFood).map(f -> f.toLowerCase()).toArray(String[]::new);
            for (String f : inputFood) {
                if (this.food.containsKey(f)) {
                    this.happinessPoints += this.food.get(f);
                }
                else {
                    this.happinessPoints--;
                }
            }
        }

        public int getHappinessPoints() {
            return this.happinessPoints;
        }

        public String getMood() {
            if (this.happinessPoints < -5) {
                return "Angry";
            } else if (this.happinessPoints < 0) {
                return "Sad";
            } else if (this.happinessPoints < 15) {
                return "Happy";
            } else {
                return "JavaScript";
            }
        }
    }
}
