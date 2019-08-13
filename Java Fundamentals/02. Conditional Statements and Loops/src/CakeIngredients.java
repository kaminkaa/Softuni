import java.util.Scanner;

/**
 * Created by Cammi on 24/09/2017.
 */
public class CakeIngredients {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = "";
        int count = 0;

        input = console.nextLine();

        while (!input.equals("Bake!")){
            System.out.println("Adding ingredient " + input + ".");
            count++;
            input = console.nextLine();
        }

        System.out.println("Preparing cake with " + count + " ingredients.");
    }
}
