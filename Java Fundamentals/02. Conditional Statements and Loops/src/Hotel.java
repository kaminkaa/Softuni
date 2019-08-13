import java.util.Scanner;

/**
 * Created by Cammi on 21/09/2017.
 */
public class Hotel {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String month = console.nextLine();
        int nights = Integer.parseInt(console.nextLine());

        double studioprice = 0;
        double doubleprice = 0;
        double suiteprice = 0;

        if(month.equals("May") || month.equals("October")){
            studioprice = 50*nights;
            if(nights>7 && month.equals("October")){
                studioprice = studioprice - 50;
            }
            if(nights>7){
                studioprice = studioprice - studioprice*0.05;
            }
            doubleprice = 65*nights;
            suiteprice = 75*nights;
        } else if (month.equals("June") || month.equals("September")){
            studioprice = 60*nights;
            if(nights>7 && month.equals("September")){
                studioprice = studioprice - 60;
            }
            doubleprice = 72*nights;
            if(nights>14){
                doubleprice = doubleprice - doubleprice*0.1;
            }
            suiteprice = 82*nights;
        } else if (month.equals("July") || month.equals("August") || month.equals("December")){
            studioprice = 68*nights;
            doubleprice = 77*nights;
            suiteprice = 89*nights;
            if(nights>14){
                suiteprice = suiteprice - suiteprice*0.15;
            }
        }

        System.out.printf("Studio: %.2f lv.", studioprice);
        System.out.println();
        System.out.printf("Double: %.2f lv.", doubleprice);
        System.out.println();
        System.out.printf("Suite: %.2f lv.", suiteprice);
        System.out.println();
    }
}
