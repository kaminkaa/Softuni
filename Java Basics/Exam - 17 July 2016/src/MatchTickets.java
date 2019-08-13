import java.util.Scanner;

/**
 * Created by Cammi on 22/07/2017.
 */
public class MatchTickets {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double budget = Double.parseDouble(console.nextLine());
        String ticketCategory = console.nextLine().toLowerCase();
        int people = Integer.parseInt(console.nextLine());

        double moneyForTravel=0;

        if(people>=1 && people<=4){
            moneyForTravel = budget*0.75;
        } else if (people>=5 && people <=9){
            moneyForTravel = budget*0.6;
        } else if (people>=10 && people <=24){
            moneyForTravel = budget*0.5;
        } else if (people>=25 && people <=49){
            moneyForTravel = budget*0.4;
        } else if (people >=50){
            moneyForTravel = budget*0.25;
        }

        double remainingBudget = budget-moneyForTravel;

        double price = 0;
        if(ticketCategory.equals("vip")){
            price = 499.99;
        } else if(ticketCategory.equals("normal")){
            price = 249.99;
        }

        double ticketsCost = people*price;

        if(remainingBudget>=ticketsCost){
            double remaining = remainingBudget - ticketsCost;
            System.out.printf("Yes! You have %.2f leva left.", remaining);
        } else {
            double needing = ticketsCost - remainingBudget;
            System.out.printf("Not enough money! You need %.2f leva.", needing);
        }


    }
}
