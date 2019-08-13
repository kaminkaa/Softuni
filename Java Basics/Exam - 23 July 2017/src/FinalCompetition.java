import java.util.Scanner;

/**
 * Created by Cammi on 23/07/2017.
 */
public class FinalCompetition {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int dancers = Integer.parseInt(console.nextLine());
        double points = Double.parseDouble(console.nextLine());
        String season = console.nextLine().toLowerCase();
        String location = console.nextLine().toLowerCase();

        double price = 0;
        double priceMinusTheExpenses = 0;

        switch (location){
            case "bulgaria":
                price = points*dancers;
                if(season.equals("summer")){
                    priceMinusTheExpenses = price-price*0.05;
                } else if (season.equals("winter")){
                    priceMinusTheExpenses = price-price*0.08;
                }
                break;
            case "abroad":
                price = points*dancers + points*dancers*0.5;
                if(season.equals("summer")){
                    priceMinusTheExpenses = price-price*0.1;
                } else if (season.equals("winter")){
                    priceMinusTheExpenses = price-price*0.15;
                }
                break;
        }

        double amountForCharity = priceMinusTheExpenses*0.75;
        double amountPerDancer = (priceMinusTheExpenses - amountForCharity)/dancers;

        System.out.printf("Charity - %.2f", amountForCharity);
        System.out.println();
        System.out.printf("Money per dancer - %.2f", amountPerDancer);
    }
}
