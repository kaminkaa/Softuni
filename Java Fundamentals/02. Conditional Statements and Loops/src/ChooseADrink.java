import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class ChooseADrink {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String profession = console.nextLine();

        if(profession.equals("Athlete")){
            System.out.printf("Water");
        } else if (profession.equals("Businessman") || profession.equals("Businesswoman")){
            System.out.printf("Coffee");
        } else if (profession.equals("SoftUni Student")){
            System.out.printf("Beer");
        } else {
            System.out.printf("Tea");
        }
    }
}
