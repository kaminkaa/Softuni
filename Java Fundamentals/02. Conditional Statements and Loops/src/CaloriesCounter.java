import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class CaloriesCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        int calories = 0;
        String ingredient = "";

        for (int i=0; i<n; i++){
            ingredient = console.nextLine().toLowerCase();
            switch (ingredient){
                case "cheese" : calories += 500;
                break;

                case "tomato sauce" : calories += 150;
                break;

                case "salami" : calories += 600;
                break;

                case "pepper" : calories += 50;
                break;

                default: calories += 0;
                break;
            }
        }

        System.out.println("Total calories: " + calories);
    }
}
