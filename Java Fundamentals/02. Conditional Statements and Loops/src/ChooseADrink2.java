import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class ChooseADrink2
{
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String profession = console.nextLine();
        int quantity = Integer.parseInt(console.nextLine());

        double waterprice = 0.7;
        double coffeeprice = 1;
        double beerprice = 1.7;
        double teaprice = 1.2;

        if(profession.equals("Athlete")){
            System.out.printf("The %s has to pay %.2f.", profession, waterprice*quantity);
        } else if (profession.equals("Businessman") || profession.equals("Businesswoman")){
            System.out.printf("The %s has to pay %.2f.", profession, coffeeprice*quantity);
        } else if (profession.equals("SoftUni Student")){
            System.out.printf("The %s has to pay %.2f.", profession, beerprice*quantity);
        } else {
            System.out.printf("The %s has to pay %.2f.", profession, teaprice*quantity);
        }
    }
}
